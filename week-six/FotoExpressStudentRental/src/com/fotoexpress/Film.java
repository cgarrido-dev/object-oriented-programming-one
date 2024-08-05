package com.fotoexpress;

public class Film extends Producto {
    private int sensibilidadISO;
    private String formato;

    public Film(String marca, String nombre, int sensibilidadISO, String formato) {
        super(marca, nombre);
        this.sensibilidadISO = sensibilidadISO;
        this.formato = formato;
    }

    public int getSensibilidadISO() {
        return sensibilidadISO;
    }

    public String getFormato() {
        return formato;
    }

    public boolean esCompatibleCon(Camera camara) {
    	System.out.println("Es compatible");
        return true;
    }
}
