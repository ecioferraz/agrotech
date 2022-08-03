package com.betrybe.agrotechmeasureshelter.resource;

<<<<<<< HEAD
=======
import java.io.IOException;
>>>>>>> 6015ccaf324b2f6aa7b8150358136b664abc1a4a
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
<<<<<<< HEAD
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
=======
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
>>>>>>> 6015ccaf324b2f6aa7b8150358136b664abc1a4a

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
<<<<<<< HEAD
  @Produces(MediaType.APPLICATION_JSON)
  public Image sendImage(@MultipartForm FormData data) {
    return service.sendImage(data);
  }

=======
  public Response sendUpload(@MultipartForm FormData data) throws IOException {
    java.nio.file.Path path = service.sendUpload(data);
    return Response.status(201).entity(path).build();
  }
  
>>>>>>> 6015ccaf324b2f6aa7b8150358136b664abc1a4a
}
