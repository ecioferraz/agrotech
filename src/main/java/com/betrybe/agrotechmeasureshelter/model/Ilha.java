package com.betrybe.agrotechmeasureshelter.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Ilha extends PanacheMongoEntity {

  private String name;

  private Boolean status;

  public Ilha() {}

  public Ilha(String name, Boolean status) {
    this.name = name;
    this.status = status;
  }

  public static Ilha findByName(String name) {
    return find("name", name).firstResult();
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
