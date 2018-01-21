package com.lucionei.chamadostecnicosfinal.rest;

import com.lucionei.chamadostecnicosfinal.model.Tecnico;
import com.lucionei.chamadostecnicosfinal.service.TecnicoService;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author Lucionei
 */
@Path("tecnicos")
public class TecnicoResource extends AbstractResource<TecnicoService, Tecnico> {

    @Inject
    private TecnicoService service;

    @Override
    protected TecnicoService getService() {
        return service;
    }

}
