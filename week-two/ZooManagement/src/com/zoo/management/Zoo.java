package com.zoo.management;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Animal> animales;

    public Zoo() {
        this.animales = new ArrayList<>();
    }

    public void agregarAnimal(Animal animal) {
        animales.add(animal);
        System.out.println(animal.getNombre() + " ha sido añadido al zoológico.");
    }

    public void alimentarTodosLosAnimales() {
        for (Animal animal : animales) {
            animal.alimentar();
        }
    }

    public void revisarSaludDeTodosLosAnimales() {
        for (Animal animal : animales) {
            animal.revisarSalud();
        }
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();


        // Instancias Pregunta N°2
        System.out.println("*****\nPregunta N°2 - Inicialización de Constructores\n*****");
        Animal elefante = new Animal("Dumbo", 5, "Perro", "Saludable", "hierbas");
        Herbivoro jirafa = new Herbivoro("Melman", 7, "Jirafa", "Saludable", "Hojas", true);

        zoo.agregarAnimal(elefante);
        zoo.agregarAnimal(jirafa);

        zoo.alimentarTodosLosAnimales();
        zoo.revisarSaludDeTodosLosAnimales();
        jirafa.interactuarConVisitantes();
                        
        // Instancias Pregunta N°2        
        System.out.println("\n\n*****\nPregunta N°3 - Inicialización de diferentes especies\n*****");
        Animal leon = new Mamifero("Simba", 5, "León", "Saludable", "Carne", true);
        Animal aguila = new Ave("Eagle", 3, "Águila", "Saludable", "Pescado", 2.5);
        Animal serpiente = new Reptil("Slyther", 2, "Serpiente", "Saludable", "Ratones", true);

        zoo.agregarAnimal(leon);
        zoo.agregarAnimal(aguila);
        zoo.agregarAnimal(serpiente);

        zoo.alimentarTodosLosAnimales();
        zoo.revisarSaludDeTodosLosAnimales();   
    }
}
