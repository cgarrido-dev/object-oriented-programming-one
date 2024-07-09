package com.rapidoandinoexpress.models;

public class Boleto {
    private Cliente cliente;
    private String fechaViaje;
    private String horaViaje;
    private String origen;
    private String destino;
    private String numeroAutobus;
    private String nombreChofer;

    public Boleto(Cliente cliente, String fechaViaje, String horaViaje, String origen, String destino, String numeroAutobus, String nombreChofer) {
        this.cliente = cliente;
        this.fechaViaje = fechaViaje;
        this.horaViaje = horaViaje;
        this.origen = origen;
        this.destino = destino;
        this.numeroAutobus = numeroAutobus;
        this.nombreChofer = nombreChofer;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(String fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public String getHoraViaje() {
        return horaViaje;
    }

    public void setHoraViaje(String horaViaje) {
        this.horaViaje = horaViaje;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getNumeroAutobus() {
        return numeroAutobus;
    }

    public void setNumeroAutobus(String numeroAutobus) {
        this.numeroAutobus = numeroAutobus;
    }

    public String getNombreChofer() {
        return nombreChofer;
    }

    public void setNombreChofer(String nombreChofer) {
        this.nombreChofer = nombreChofer;
    }
}
