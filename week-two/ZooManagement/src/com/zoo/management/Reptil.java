package com.zoo.management;

public class Reptil extends Animal {
    private boolean esVenenoso;

    public Reptil(String nombre, int edad, String especie, String estadoDeSalud, String dieta, boolean esVenenoso) {
        super(nombre, edad, especie, estadoDeSalud, dieta);
        this.esVenenoso = esVenenoso;
    }

    public boolean isEsVenenoso() {
        return esVenenoso;
    }

    public void setEsVenenoso(boolean esVenenoso) {
        this.esVenenoso = esVenenoso;
    }

    @Override
    public void revisarSalud() {
        super.revisarSalud();
        System.out.println("Verificando si " + getNombre() + " muestra signos de envenenamiento.");
    }
}
