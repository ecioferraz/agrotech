package com.betrybe.agrotechmeasureshelter.resource;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.reactive.MultipartForm;

import com.betrybe.agrotechmeasureshelter.model.FormData;
import com.betrybe.agrotechmeasureshelter.model.Image;
import com.betrybe.agrotechmeasureshelter.service.ImageService;

@Path("/images")
public class ImageResource {

  @Inject
  ImageService service;

  @GET
  public List<Image> list() {
    return service.list();
  }

  @POST
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @Produces(MediaType.APPLICATION_JSON)
  public Response sendUpload(@MultipartForm FormData data) throws IOException {
    java.nio.file.Path path = service.sendUpload(data);
    return Response.status(201).entity(path).build();
  }

}
