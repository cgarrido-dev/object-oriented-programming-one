package com.fotoexpress;

public class Brand {
    private String nombre;
    private ServiceStore tiendaServicioTecnico;

    public Brand(String nombre, ServiceStore tiendaServicioTecnico) {
        this.nombre = nombre;
        this.tiendaServicioTecnico = tiendaServicioTecnico;
    }

    public String obtenerDireccionTiendaServicio() {
        return tiendaServicioTecnico.obtenerDireccion();
    }
}
