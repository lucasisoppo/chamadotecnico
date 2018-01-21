package com.lucionei.chamadostecnicosfinal.model;

/**
 *
 * @author Lucionei
 */
public enum TipoChamado {
    INTERNO("INTERNO"), EXTERNO("EXTERNO");

    private final String tipo;

    TipoChamado(String valorTipo) {
        tipo = valorTipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
}
