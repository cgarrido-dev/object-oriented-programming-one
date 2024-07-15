package com.zoo.management;

public class Herbivoro extends Animal {
    private boolean esEnZonaContacto;

    public Herbivoro(String nombre, int edad, String especie, String estadoDeSalud, String dieta, boolean esEnZonaContacto) {
        super(nombre, edad, especie, estadoDeSalud, dieta);
        this.esEnZonaContacto = esEnZonaContacto;
    }

    public void interactuarConVisitantes() {
        if (esEnZonaContacto) {
            System.out.println(getNombre() + " está interactuando con los visitantes.");
        } else {
            System.out.println(getNombre() + " no está en la zona de contacto.");
        }
    }

    public boolean isEsEnZonaContacto() {
        return esEnZonaContacto;
    }

    public void setEsEnZonaContacto(boolean esEnZonaContacto) {
        this.esEnZonaContacto = esEnZonaContacto;
    }
}