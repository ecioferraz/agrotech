package com.betrybe.repository;

import javax.enterprise.context.ApplicationScoped;
import com.betrybe.agrotechmeasureshelter.model.Ilha;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

@ApplicationScoped
public class IlhaRepository implements PanacheMongoRepository<Ilha> {

  public Ilha findByName(String name) {
    return find("name", name).firstResult();
  }
}
