package com.restaurante.session;

public class Session {
    private static Long clienteId;

    public static Long getClienteId() {
        return clienteId;
    }

    public static void setClienteId(Long clienteId) {
        Session.clienteId = clienteId;
    }
}
