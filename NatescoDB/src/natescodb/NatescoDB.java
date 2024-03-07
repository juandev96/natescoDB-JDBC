/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package natescodb;

/**
 *
 * @author juanospina
 */
public class NatescoDB {

    public static void main(String[] args) {

        Producto producto = new Producto();

        producto.insertarProducto("tornillo", "500");

        producto.getDatos();

        producto.actualizarProducto("6", "tornillo", "200");

        producto.eliminarProducto("6");

        producto.getDatos();
    }

}
