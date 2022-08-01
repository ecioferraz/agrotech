package com.betrybe.agrotechmeasureshelter.model;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;

public class Image {

  public ObjectId imageId;

  private String originalName;

  private String keyName;

  private Long fileSize;

  private LocalDateTime uploadDate = LocalDateTime.now();

  public ObjectId getImageId() {
    return imageId;
  }

  public void setImageId(ObjectId imageId) {
    this.imageId = imageId;
  }

  public String getOriginalName() {
    return originalName;
  }

  public void setOriginalName(String originalName) {
    this.originalName = originalName;
  }

  public String getKeyName() {
    return keyName;
  }

  public void setKeyName(String keyName) {
    this.keyName = keyName;
  }

  public Long getFileSize() {
    return fileSize;
  }

  public void setFileSize(Long fileSize) {
    this.fileSize = fileSize;
  }

  public LocalDateTime getUploadDate() {
    return uploadDate;
  }

  public void setUploadDate(LocalDateTime uploadDate) {
    this.uploadDate = uploadDate;
  }
  
}
