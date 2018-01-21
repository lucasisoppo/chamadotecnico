package com.lucionei.chamadostecnicosfinal.rest;

import com.lucionei.chamadostecnicosfinal.model.Cliente;
import com.lucionei.chamadostecnicosfinal.service.ClienteService;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author Lucionei
 */
@Path("clientes")
public class ClienteResource extends AbstractResource<ClienteService, Cliente> {
    
    @Inject
    private ClienteService service;

    @Override
    protected ClienteService getService() {
        return service;
    }

}
