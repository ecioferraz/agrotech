package com.betrybe.agrotechmeasureshelter.resource;

import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.betrybe.agrotechmeasureshelter.exception.NotFoundException;
import com.betrybe.agrotechmeasureshelter.model.Isle;
import com.betrybe.agrotechmeasureshelter.service.IsleService;

@Path("/isles")
public class IsleResource {

  @Inject
  IsleService isleService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Isle> list() {
    return isleService.list();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response add(@Valid Isle isle) throws Exception {
    isleService.add(isle);
    return Response.status(201).build();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Isle get(@PathParam("id") String id) throws NotFoundException {
    return isleService.findById(id);
  }

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Isle update(@PathParam("id") String id, Isle isle) throws NotFoundException {
    return isleService.update(id, isle);
  }

  @DELETE
  @Path("/{id}")
  public void delete(@PathParam("id") String id) throws NotFoundException {
    isleService.delete(id);
  }

  @GET
  @Path("/search/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public Isle search(@PathParam("name") String name) {
    return isleService.search(name);
  }

  @GET
  @Path("/count")
  @Produces(MediaType.TEXT_PLAIN)
  public Long count() {
    return isleService.count();
  }

  @GET
  @Path("/drop")
  public void dropDatabase() {
    isleService.dropDatabase();
  }
}
