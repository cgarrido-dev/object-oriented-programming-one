package com.fotoexpress;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Customer {
    private String nombre;
    private String apellido;
    private String idEstudiante;
    private Camera camaraAlquilada;
    private Date fechaAlquiler;
    private boolean penalizado;

    public Customer(String nombre, String apellido, String idEstudiante) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idEstudiante = idEstudiante;
        this.camaraAlquilada = null;
        this.fechaAlquiler = null;
        this.penalizado = false;
    }

    public boolean alquilarCamara(Camera camara) {
        if (this.camaraAlquilada != null) {
            System.out.println("Ya tiene una cámara alquilada.");
            return false;
        }

        if (!camara.verificarDisponibilidad()) {
            System.out.println("La cámara no está disponible.");
            return false;
        }

        this.camaraAlquilada = camara;
        this.fechaAlquiler = new Date();
        camara.alquilar();
        return true;
    }

    public void devolverCamara() {
        if (this.camaraAlquilada == null) {
            System.out.println("No tiene ninguna cámara para devolver.");
            return;
        }

        if (verificarPenalizacion()) {
            System.out.println("Se ha aplicado una penalización por demora en la devolución.");
            this.penalizado = true;
        } else {
            this.penalizado = false;
        }

        camaraAlquilada.devolver();
        this.camaraAlquilada = null;
        this.fechaAlquiler = null;
    }

    public boolean verificarPenalizacion() {
        if (this.camaraAlquilada == null) return false;

        long diffInMillies = Math.abs(new Date().getTime() - this.fechaAlquiler.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        if (diff > 8) {
            System.out.println("Penalización aplicada: 3 meses sin poder alquilar.");
            return true;
        }
        return false;
    }
}
