package com.betrybe.agrotechmeasureshelter.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.eclipse.microprofile.config.inject.ConfigProperty;
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

  private List<String> mimeType =
      Arrays.asList("image/jpeg", "image/png", "image/pjpeg", "image/gif");

  public List<Image> list() {
    return repository.listAll();
  }

  @Transactional
  public Image sendImage(FormData data) {
    System.out.println("|||||||||||");
    System.out.println(data.getFile().fileName());
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
    return PutObjectRequest.builder().bucket(bucketName).key(keyName)
        .contentType(file.contentType()).build();
  }

  // método get do s3, tirado da documentação, não sei se vamos precisar usar
  // private GetObjectRequest buildGetRequest(String keyName) {
  // return GetObjectRequest.builder()
  // .bucket(bucketName)
  // .key(keyName)
  // .build();
  // }


  private String generateKeyName(FileUpload file) {
    return UUID.randomUUID() + "-" + file.fileName();
  }

}
