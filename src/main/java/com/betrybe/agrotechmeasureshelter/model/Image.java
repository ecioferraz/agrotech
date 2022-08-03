package com.betrybe.agrotechmeasureshelter.model;

import java.time.LocalDateTime;


public class Image {

  public Image() {}

  public Image(String path) {
    this.path = path;
  }

  public LocalDateTime createdAt = LocalDateTime.now();

  private String path;

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }
}
