package com.lucionei.chamadostecnicosfinal.rest;

import com.lucionei.chamadostecnicosfinal.model.Equipamento;
import com.lucionei.chamadostecnicosfinal.service.EquipamentoService;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author Lucionei
 */
@Path("equipamentos")
public class EquipamentoResource extends AbstractResource<EquipamentoService, Equipamento> {

    @Inject
    private EquipamentoService service;

    @Override
    public EquipamentoService getService() {
        return service;
    }
}
