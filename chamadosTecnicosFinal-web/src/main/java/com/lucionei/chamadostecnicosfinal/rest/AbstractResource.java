package com.lucionei.chamadostecnicosfinal.rest;

import com.lucionei.chamadostecnicosfinal.model.BaseEntity;
import com.lucionei.chamadostecnicosfinal.service.AbstractService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Lucionei
 * @param <T>
 * @param <B>
 */
public abstract class AbstractResource<T extends AbstractService<B>, B extends BaseEntity> {

    protected abstract T getService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(@DefaultValue("0") @QueryParam("offset") Integer offset,
            @DefaultValue("50") @QueryParam("limit") int limit,
            @DefaultValue("+descricao") @QueryParam("sort") String sort) {
        return Response.ok(getService().findAll(offset, limit, sort)).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(getService().findById(id)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(B obj) {
        return Response.status(Response.Status.CREATED)
                .entity(getService().insert(obj))
                .build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        getService().delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(B obj, @PathParam("id") Long id) {
        if (!id.equals(obj.getId())) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Objeto Com ID Diferente Do Informado Na URL.")
                    .build();
        }        
        return Response.status(Response.Status.OK)
                .entity(getService().update(obj))
                .build();
    }

}
