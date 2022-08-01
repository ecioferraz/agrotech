package com.betrybe.agrotechmeasureshelter.repository;

import javax.enterprise.context.ApplicationScoped;
import com.betrybe.agrotechmeasureshelter.model.Isle;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

@ApplicationScoped
public class IsleRepository implements PanacheMongoRepository<Isle> {

  public Isle findByName(String name) {
    return find("name", name).firstResult();
  }
}
