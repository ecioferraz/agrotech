package com.betrybe.agrotechmeasureshelter.repository;

import javax.enterprise.context.ApplicationScoped;

import com.betrybe.agrotechmeasureshelter.model.Image;

import io.quarkus.mongodb.panache.PanacheMongoRepository;

@ApplicationScoped
public class ImagesRepository implements PanacheMongoRepository<Image> {
  
}
