package com.rapidoandinoexpress.services;

import com.rapidoandinoexpress.models.Cliente;

public class AutenticacionServicio {

    public boolean verificarDocumento(Cliente cliente) {
        String documento = cliente.getDocumentoIdentificacion();
        return esDocumentoValido(documento);
    }

    private boolean esDocumentoValido(String documento) {
        return documento != null && !documento.trim().isEmpty();
    }
}
