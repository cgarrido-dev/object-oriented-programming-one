package com.fotoexpress;

public class Camera extends Producto {
    private String modelo;
    private boolean soporteFlash;
    private boolean disponible;

    public Camera(String marca, String nombre, String modelo, boolean soporteFlash) {
        super(marca, nombre);
        this.modelo = modelo;
        this.soporteFlash = soporteFlash;
        this.disponible = true;
    }

    public boolean alquilar() {
        if (this.disponible) {
            this.disponible = false;
            return true;
        }
        return false;
    }

    public void devolver() {
        this.disponible = true;
    }

    public boolean verificarDisponibilidad() {
        return this.disponible;
    }

    public String getModelo() {
        return modelo;
    }

    public boolean isSoporteFlash() {
        return soporteFlash;
    }
}
