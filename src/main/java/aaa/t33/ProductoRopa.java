/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aaa.t33;

/**
 *
 * @author diego
 */
public class ProductoRopa extends Ropa implements GestionPrecios {
    public ProductoRopa(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public String getCategoria() {
        return "Ropa";
    }

    @Override
    public void actualizarPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
    }

    @Override
    public double obtenerPrecio() {
        return precio;
    }
}
