package com.betrybe.agrotechmeasureshelter.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.betrybe.agrotechmeasureshelter.model.FormData;
import com.betrybe.agrotechmeasureshelter.model.Image;
import com.betrybe.agrotechmeasureshelter.repository.ImagesRepository;

@ApplicationScoped
public class ImageService {

  @ConfigProperty(name = "quarkus.http.body.uploads-directory")
  String directory;

  @Inject
  ImagesRepository repository;

  public List<Image> list() {
    return repository.listAll();
  }

  @Transactional
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

}
