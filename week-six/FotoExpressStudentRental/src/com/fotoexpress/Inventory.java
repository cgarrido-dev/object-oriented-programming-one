package com.fotoexpress;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Camera> camaras;
    private List<Film> peliculas;

    public Inventory() {
        this.camaras = new ArrayList<>();
        this.peliculas = new ArrayList<>();
    }

    public void agregarCamara(Camera camara) {
        this.camaras.add(camara);
    }

    public void eliminarCamara(Camera camara) {
        this.camaras.remove(camara);
    }

    public void agregarPelicula(Film pelicula) {
        this.peliculas.add(pelicula);
    }

    public void eliminarPelicula(Film pelicula) {
        this.peliculas.remove(pelicula);
    }

    public Camera buscarCamara(String modelo) {
        for (Camera camara : camaras) {
            if (camara.getModelo().equals(modelo)) {
                return camara;
            }
        }
        return null;
    }

    public List<Camera> listarCamarasDisponibles() {
        List<Camera> disponibles = new ArrayList<>();
        for (Camera camara : camaras) {
            if (camara.verificarDisponibilidad()) {
                disponibles.add(camara);
            }
        }
        return disponibles;
    }
}
