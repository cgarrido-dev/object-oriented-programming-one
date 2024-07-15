package com.zoo.management;

public class Mamifero extends Animal {
    private boolean tienePelaje;

    public Mamifero(String nombre, int edad, String especie, String estadoDeSalud, String dieta, boolean tienePelaje) {
        super(nombre, edad, especie, estadoDeSalud, dieta);
        this.tienePelaje = tienePelaje;
    }

    public boolean isTienePelaje() {
        return tienePelaje;
    }

    public void setTienePelaje(boolean tienePelaje) {
        this.tienePelaje = tienePelaje;
    }

    @Override
    public void revisarSalud() {
        super.revisarSalud();
        System.out.println("Verificando el pelaje de " + getNombre());
    }
}
