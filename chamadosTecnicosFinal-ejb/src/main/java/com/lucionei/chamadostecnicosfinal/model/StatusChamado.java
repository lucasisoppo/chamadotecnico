package com.lucionei.chamadostecnicosfinal.model;

/**
 *
 * @author Lucionei
 */
public enum StatusChamado {
    ABERTO("ABERTO"), APROVADO("APROVADO"), CANCELADO("CANCELADO"), FINALIZADO("FINALIZADO");

    private final String status;

    StatusChamado(String valorStatus) {
        status = valorStatus;
    }

    public String toString(){
        return status;
    }
}
