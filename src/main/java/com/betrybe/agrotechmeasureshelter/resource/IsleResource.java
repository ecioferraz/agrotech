package com.betrybe.agrotechmeasureshelter.resource;

import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import com.betrybe.agrotechmeasureshelter.Exception.NotFoundException;
import com.betrybe.agrotechmeasureshelter.model.Isle;
import com.betrybe.agrotechmeasureshelter.service.IsleService;

@Path("/isle")
public class IsleResource {

  @Inject
  IsleService isleService;

  @GET
  public List<Isle> list() {
    return isleService.list();
  }

  @POST
  public List<Isle> add(@Valid Isle isle) throws Exception {
    isleService.add(isle);
    return list();
  }

  @GET
  @Path("/{id}")
  public Isle get(@PathParam("id") String id) throws NotFoundException {
    return isleService.findById(id);
  }

  @PUT
  @Path("/{id}")
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
  public Isle search(@PathParam("name") String name) {
    return isleService.search(name);
  }

  @GET
  @Path("/count")
  public Long count() {
    return isleService.count();
  }

  @GET
  @Path("/drop")
  public void dropDatabase() {
    isleService.dropDatabase();
  }
}
