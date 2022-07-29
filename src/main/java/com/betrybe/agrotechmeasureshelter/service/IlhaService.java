package com.betrybe.agrotechmeasureshelter.service;

import com.betrybe.agrotechmeasureshelter.model.Ilha;
import org.bson.types.ObjectId;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class IlhaService {

  public List<Ilha> list() {
    List<Ilha> ilhas = Ilha.listAll();
    return ilhas;
  }

  public void add(Ilha ilha) {
    Ilha.persist(ilha);
  }

  public Ilha findById(String id) {
    Ilha ilha = Ilha.findById(new ObjectId(id));
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
    updateIlha.update();
    return updateIlha;
  }

  public void delete(String id) {
    Ilha ilha = findById(id);
    ilha.delete();
  }

  public Ilha search(String name) {
    return Ilha.findByName(name);
  }

  public Long count() {
    return Ilha.count();
  }

  public void dropDatabase() {
    Ilha.deleteAll();
  }

}
