package com.betrybe.agrotechmeasureshelter.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import com.betrybe.agrotechmeasureshelter.model.Medidas;
import com.betrybe.agrotechmeasureshelter.repository.MedidasRepository;

@ApplicationScoped
public class MedidasService {

  @Inject
  MedidasRepository medidasRepository;

  public List<Medidas> list() {
    List<Medidas> medidas = medidasRepository.listAll();
    return medidas;
  }

  public void add(Medidas medidas) {
    medidasRepository.persist(medidas);
  }
}
