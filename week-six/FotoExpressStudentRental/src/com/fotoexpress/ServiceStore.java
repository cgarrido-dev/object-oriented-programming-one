package com.fotoexpress;

public class ServiceStore {
    private String direccion;

    public ServiceStore(String direccion) {
        this.direccion = direccion;
    }

    public String obtenerDireccion() {
        return direccion;
    }
}
