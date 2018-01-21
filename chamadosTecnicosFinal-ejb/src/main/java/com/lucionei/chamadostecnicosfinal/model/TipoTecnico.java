package com.lucionei.chamadostecnicosfinal.model;

/**
 *
 * @author Lucionei
 */
public enum TipoTecnico {
    
    TECNICO("TECNICO"), GERENTE("GERENTE");

    private final String tipoTecnico;

    TipoTecnico(String tipoTecnico) {
        this.tipoTecnico = tipoTecnico;
    }

    @Override
    public String toString() {
        return tipoTecnico;
    }
    
}
