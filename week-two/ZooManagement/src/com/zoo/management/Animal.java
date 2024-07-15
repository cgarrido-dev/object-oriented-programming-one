package com.zoo.management;

public class Animal {
    private String nombre;
    private int edad;
    private String especie;
    private String estadoDeSalud;
    private String dieta;

    public Animal(String nombre, int edad, String especie, String estadoDeSalud, String dieta) {
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
        this.estadoDeSalud = estadoDeSalud;
        this.dieta = dieta;
    }

    public void alimentar() {
        System.out.println(nombre + " está siendo alimentado con " + dieta);
    }

    public void revisarSalud() {
        System.out.println("Revisando la salud de " + nombre + ". Estado de salud actual: " + estadoDeSalud);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getEstadoDeSalud() {
        return estadoDeSalud;
    }

    public void setEstadoDeSalud(String estadoDeSalud) {
        this.estadoDeSalud = estadoDeSalud;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }
}