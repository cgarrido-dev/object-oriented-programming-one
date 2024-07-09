package com.rapidoandinoexpress.services;

import com.rapidoandinoexpress.models.Cliente;
import com.rapidoandinoexpress.models.Boleto;
import java.util.HashMap;
import java.util.Map;

public class VentaServicio {
    private Map<String, Boleto> boletosEmitidos = new HashMap<>();

    public boolean puedeComprarBoleto(Cliente cliente) {
        return !boletosEmitidos.containsKey(cliente.getDocumentoIdentificacion());
    }

    public Boleto venderBoleto(Cliente cliente, String fechaViaje, String horaViaje, String origen, String destino, String numeroAutobus,
    		String nombreChofer) {
        if (puedeComprarBoleto(cliente)) {
            Boleto boleto = new Boleto(cliente, fechaViaje, horaViaje, origen, destino, numeroAutobus, nombreChofer);
            boletosEmitidos.put(cliente.getDocumentoIdentificacion(), boleto);
            return boleto;
        }
        return null;
    }
    
    public Boleto procesarPagoYEmitirBoleto(Cliente cliente, String fechaViaje, String horaViaje, String origen, String destino,
    		String numeroAutobus, String nombreChofer) {
        boolean pagoExitoso = procesarPago(cliente);
        if (pagoExitoso) {
            return venderBoleto(cliente, fechaViaje, horaViaje, origen, destino, numeroAutobus, nombreChofer);
        }
        return null;
    }

    private boolean procesarPago(Cliente cliente) {
        return true;
    }

}
