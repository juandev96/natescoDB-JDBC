/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package natescodb;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author juanospina
 */
public class Producto {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public Producto() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:8889/natesco", "root", "root");
            st = con.createStatement();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void insertarProducto(String nombreProducto, String valorProducto) {
        try {
            String query = "INSERT INTO Producto (nombreProducto, valorProducto) VALUES (?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, nombreProducto);
            preparedStatement.setString(2, valorProducto);
            preparedStatement.executeUpdate();
            System.out.println("Producto insertado correctamente.");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void getDatos() {

        try {

            String query = "SELECT * FROM Producto";
            rs = st.executeQuery(query);

            while (rs.next()) {
                String id = rs.getString("Id_Producto");
                String nombreProducto = rs.getString("nombreProducto");
                String valorProducto = rs.getString("valorProducto");
                System.out.println("---------\nId: " + id + "\nNombre Producto: " + nombreProducto + "\nValor Producto: " + valorProducto);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void actualizarProducto(String id, String nuevoNombre, String nuevoValor) {
        try {
            String query = "UPDATE Producto SET nombreProducto=?, valorProducto=? WHERE Id_Producto=?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, nuevoNombre);
            preparedStatement.setString(2, nuevoValor);
            preparedStatement.setString(3, id);
            preparedStatement.executeUpdate();
            System.out.println("Producto actualizado correctamente.");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }
    
    public void eliminarProducto(String id) {
        try {
            String query = "DELETE FROM Producto WHERE Id_Producto=?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Producto eliminado correctamente.");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }
    
    private void cerrarConexion() {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (con != null) con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
