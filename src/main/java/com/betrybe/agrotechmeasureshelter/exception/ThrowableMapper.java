package com.betrybe.agrotechmeasureshelter.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ThrowableMapper implements ExceptionMapper<Throwable> {

  @Override
  public Response toResponse(Throwable exception) {
    var mensagemErro = exception.getMessage();
    var erro = new ErrorMessage(mensagemErro);
    return Response.status(404).entity(erro).build();
  }
}
