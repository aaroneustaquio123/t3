/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aaa.t33;

/**
 *
 * @author diego
 */
public abstract class Ropa {
    protected String nombre;
    protected double precio;

    public Ropa(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public abstract String getCategoria();
}
