package com.betrybe.agrotechmeasureshelter.resource;

import java.io.File;
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
import javax.ws.rs.core.Response.ResponseBuilder;
import org.jboss.resteasy.reactive.MultipartForm;
import com.betrybe.agrotechmeasureshelter.model.FormData;
import com.betrybe.agrotechmeasureshelter.model.Image;
import com.betrybe.agrotechmeasureshelter.service.ImageService;
import io.smallrye.mutiny.Uni;

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
    service.sendUpload(data);
    return Response.status(201).build();
  }

  @GET
  @Path("/{date}")
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public Uni<Response> donwloadByDate(@PathParam("date") String date) {
    String path = service.getByDate(date);
    File nf = new File(path);
    ResponseBuilder response = Response.ok(nf);
    response.header("Content-Disposition", "attachment;filename=" + nf);
    Uni<Response> re = Uni.createFrom().item(response.build());
    return re;
  }
}
