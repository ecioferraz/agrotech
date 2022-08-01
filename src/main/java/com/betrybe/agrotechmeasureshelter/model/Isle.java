package com.betrybe.agrotechmeasureshelter.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.bson.types.ObjectId;

public class Isle {

  public ObjectId id;

  @NotBlank(message = "name is required!")
  private String name;

  @NotNull(message = "status is required!")
  private Boolean status;

  public Isle() {}

  public Isle(String name, Boolean status) {
    this.name = name;
    this.status = status;
  }

  /**
   * Retorna o name.
   */
  public String getName() {
    return name;
  }

  /**
   * Altera o name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Retorna o status.
   */
  public Boolean getStatus() {
    return status;
  }

  /**
   * Altera o status.
   */
  public void setStatus(Boolean status) {
    this.status = status;
  }

}
