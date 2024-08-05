package com.fotoexpress;

public abstract class Producto {
    protected String marca;
    protected String nombre;

    public Producto(String marca, String nombre) {
        this.marca = marca;
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public String getNombre() {
        return nombre;
    }
}
