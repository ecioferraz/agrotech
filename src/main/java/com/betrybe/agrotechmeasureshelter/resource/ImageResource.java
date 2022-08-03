package com.betrybe.agrotechmeasureshelter.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
  public Image sendImage(@MultipartForm FormData data) {
    return service.sendImage(data);
  }

}
