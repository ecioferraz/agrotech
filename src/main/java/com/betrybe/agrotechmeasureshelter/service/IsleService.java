package com.betrybe.agrotechmeasureshelter.service;

import com.betrybe.agrotechmeasureshelter.model.Isle;
import com.betrybe.repository.IsleRepository;
import org.bson.types.ObjectId;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class IsleService {

  @Inject
  IsleRepository isleRepository;

  public List<Isle> list() {
    List<Isle> isles = isleRepository.listAll();
    return isles;
  }

  public void add(Isle isle) {
    isleRepository.persist(isle);
  }

  public Isle findById(String id) {
    Isle isle = isleRepository.findById(new ObjectId(id));
    // Precisa criar essa classe
    // if (isle == null) {
    // throw new NotFoundException();
    // }
    return isle;
  }

  public Isle update(String id, Isle isle) {
    Isle isleToUpdate = findById(id);
    isleToUpdate.setName(isle.getName());
    isleToUpdate.setStatus(isle.getStatus());
    isleRepository.update(isleToUpdate);
    return isleToUpdate;
  }

  public void delete(String id) {
    Isle isle = findById(id);
    isleRepository.delete(isle);
  }

  public Isle search(String name) {
    return isleRepository.findByName(name);
  }

  public Long count() {
    return isleRepository.count();
  }

  public void dropDatabase() {
    isleRepository.deleteAll();
  }

}
