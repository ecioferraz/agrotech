package com.betrybe.agrotechmeasureshelter.resource;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    Image image = service.sendUpload(data);
    return Response.status(201).entity(image).build();
  }

  @GET
  @Path("/{date}")
  public Response donwloadByDate(@PathParam("date") String date) {
    java.nio.file.Path path = service.getByDate(date);
    return Response.status(200).entity(path).build();
  }
}
