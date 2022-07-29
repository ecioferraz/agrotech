package com.betrybe.agrotechmeasureshelter.resource;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import com.betrybe.agrotechmeasureshelter.model.Ilha;
import com.betrybe.agrotechmeasureshelter.service.IlhaService;

@Path("/ilha")
public class IlhaResource {

  @Inject
  IlhaService ilhaService;

  @GET
  public List<Ilha> list() {
    return ilhaService.list();
  }

  @POST
  public List<Ilha> add(Ilha ilha) {
    ilhaService.add(ilha);
    return list();
  }

  @GET
  @Path("/{id}")
  public Ilha get(@PathParam("id") String id) {
    return ilhaService.findById(id);
  }

  @PUT
  @Path("/{id}")
  public Ilha update(@PathParam("id") String id, Ilha ilha) {
    return ilhaService.update(id, ilha);
  }

  @DELETE
  @Path("/{id}")
  public void delete(@PathParam("id") String id) {
    ilhaService.delete(id);
  }

  @GET
  @Path("/search/{name}")
  public Ilha search(@PathParam("name") String name) {
    return ilhaService.search(name);
  }

  @GET
  @Path("/count")
  public Long count() {
    return ilhaService.count();
  }

  @GET
  @Path("/drop")
  public void dropDatabase() {
    ilhaService.dropDatabase();
  }
}
