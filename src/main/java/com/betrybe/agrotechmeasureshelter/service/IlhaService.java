package com.betrybe.agrotechmeasureshelter.service;

import com.betrybe.agrotechmeasureshelter.model.Ilha;
import com.betrybe.repository.IlhaRepository;
import org.bson.types.ObjectId;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class IlhaService {

  @Inject
  IlhaRepository ilhaRepository;

  public List<Ilha> list() {
    List<Ilha> ilhas = ilhaRepository.listAll();
    return ilhas;
  }

  public void add(Ilha ilha) {
    ilhaRepository.persist(ilha);
  }

  public Ilha findById(String id) {
    Ilha ilha = ilhaRepository.findById(new ObjectId(id));
    // Precisa criar essa classe
    // if (ilha == null) {
    // throw new NotFoundException();
    // }
    return ilha;
  }

  public Ilha update(String id, Ilha ilha) {
    Ilha updateIlha = findById(id);
    updateIlha.setName(ilha.getName());
    updateIlha.setStatus(ilha.getStatus());
    ilhaRepository.update(updateIlha);
    return updateIlha;
  }

  public void delete(String id) {
    Ilha ilha = findById(id);
    ilhaRepository.delete(ilha);
  }

  public Ilha search(String name) {
    return ilhaRepository.findByName(name);
  }

  public Long count() {
    return ilhaRepository.count();
  }

  public void dropDatabase() {
    ilhaRepository.deleteAll();
  }

}
