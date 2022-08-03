package com.betrybe.agrotechmeasureshelter.model;

import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

<<<<<<< HEAD
public class FormData {
  
=======

public class FormData {
 
>>>>>>> 6015ccaf324b2f6aa7b8150358136b664abc1a4a
  @RestForm("file")
  private FileUpload file;

  public FileUpload getFile() {
    return file;
  }

}
