package com.lucionei.chamadostecnicosfinal.rest;

import com.lucionei.chamadostecnicosfinal.model.ChamadoTecnico;
import com.lucionei.chamadostecnicosfinal.service.ChamadoTecnicoService;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author lucionei.chequeto
 */
@Path("chamados")
public class ChamadoTecnicoResource extends AbstractResource<ChamadoTecnicoService, ChamadoTecnico> {

    @Inject
    ChamadoTecnicoService service;

    @Override
    protected ChamadoTecnicoService getService() {
        return service;
    }

}
