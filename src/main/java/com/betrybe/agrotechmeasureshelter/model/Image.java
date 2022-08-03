package com.betrybe.agrotechmeasureshelter.model;

import java.time.LocalDateTime;

<<<<<<< HEAD
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
  
=======
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

>>>>>>> 6015ccaf324b2f6aa7b8150358136b664abc1a4a
}
