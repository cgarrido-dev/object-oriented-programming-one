package com.zoo.management;

public class Ave extends Animal {
    private double envergaduraAlas;

    public Ave(String nombre, int edad, String especie, String estadoDeSalud, String dieta, double envergaduraAlas) {
        super(nombre, edad, especie, estadoDeSalud, dieta);
        this.envergaduraAlas = envergaduraAlas;
    }

    public double getEnvergaduraAlas() {
        return envergaduraAlas;
    }

    public void setEnvergaduraAlas(double envergaduraAlas) {
        this.envergaduraAlas = envergaduraAlas;
    }

    @Override
    public void revisarSalud() {
        super.revisarSalud();
        System.out.println("Verificando las alas de " + getNombre());
    }
}
