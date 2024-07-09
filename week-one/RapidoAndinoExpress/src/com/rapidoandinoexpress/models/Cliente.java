package com.rapidoandinoexpress.models;

public class Cliente {
    private String nombre;
    private String documentoIdentificacion;

    public Cliente(String nombre, String documentoIdentificacion) {
        this.nombre = nombre;
        this.documentoIdentificacion = documentoIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumentoIdentificacion() {
        return documentoIdentificacion;
    }

    public void setDocumentoIdentificacion(String documentoIdentificacion) {
        this.documentoIdentificacion = documentoIdentificacion;
    }
}
