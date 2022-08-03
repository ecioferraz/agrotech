package com.betrybe.agrotechmeasureshelter.service;

<<<<<<< HEAD
=======
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
>>>>>>> 6015ccaf324b2f6aa7b8150358136b664abc1a4a
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.eclipse.microprofile.config.inject.ConfigProperty;
<<<<<<< HEAD
import org.jboss.resteasy.reactive.multipart.FileUpload;

import com.betrybe.agrotechmeasureshelter.model.FormData;
import com.betrybe.agrotechmeasureshelter.model.Image;
import com.betrybe.agrotechmeasureshelter.repository.ImageRepository;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@ApplicationScoped
public class ImageService {

  @ConfigProperty(name = "bucket.name")
  String bucketName;

  @Inject
  S3Client s3;
  
  @Inject
  ImageRepository repository;

  private List<String> mimeType = Arrays.asList("image/jpeg", "image/png", "image/pjpeg", "image/gif");
=======

import com.betrybe.agrotechmeasureshelter.model.FormData;
import com.betrybe.agrotechmeasureshelter.model.Image;
import com.betrybe.agrotechmeasureshelter.repository.ImagesRepository;

@ApplicationScoped
public class ImageService {
  
  @ConfigProperty(name = "quarkus.http.body.uploads-directory")
  String directory;

  @Inject
  ImagesRepository repository;
>>>>>>> 6015ccaf324b2f6aa7b8150358136b664abc1a4a

  public List<Image> list() {
    return repository.listAll();
  }

  @Transactional
<<<<<<< HEAD
  public Image sendImage(FormData data) {
    if (data.getFile() == null) {
      throw new RuntimeException("File not send");
    }

    FileUpload file = data.getFile();

    if (!mimeType.contains(file.contentType())) {
      throw new RuntimeException("File not supported");
    }

    if (file.size() > 1024 * 1024 * 4) {
      throw new RuntimeException("File is too large");
    }

    String keyName = generateKeyName(file);

    Image image = new Image();

    image.setOriginalName(file.fileName());
    image.setKeyName(keyName);
    image.setFileSize(file.size());

    PutObjectRequest putObjectRequest = buildPutRequest(keyName, file);
    
    s3.putObject(putObjectRequest, RequestBody.fromFile(file.filePath()));

    repository.persist(image);

    return image;
  }

  private PutObjectRequest buildPutRequest(String keyName, FileUpload file) {
    return PutObjectRequest.builder()
        .bucket(bucketName)
        .key(keyName)
        .contentType(file.contentType())
        .build();
  }

  // método get do s3, tirado da documentação, não sei se vamos precisar usar
  // private GetObjectRequest buildGetRequest(String keyName) {
  //   return GetObjectRequest.builder()
  //           .bucket(bucketName)
  //           .key(keyName)
  //           .build();
  // }


  private String generateKeyName(FileUpload file) {
    return UUID.randomUUID() + "-" + file.fileName();
  }
  
=======
  public Path sendUpload(FormData data) throws IOException {

    List<String> mimetype = Arrays.asList("image/jpg", "image/jpeg", "image/gif", "image/png");

    if (!mimetype.contains(data.getFile().contentType())) {
      throw new IOException("File not supported");
    }

    if (data.getFile().size() > 1024 * 1024 * 4) {
      throw new IOException("File is too large");
    }

    // Image image = new Image();

    String fileName = UUID.randomUUID() + "-" + data.getFile().fileName();

    // image.setOriginalName(data.getFile().fileName());
    // image.setKeyName(fileName);
    // image.setMimetype(data.getFile().contentType());
    // image.setFileSize(data.getFile().size());
    
    // repository.persist(image);

    Path path = Files.copy(data.getFile().filePath(), Paths.get(directory + fileName));
    
    return path;
  }

>>>>>>> 6015ccaf324b2f6aa7b8150358136b664abc1a4a
}
