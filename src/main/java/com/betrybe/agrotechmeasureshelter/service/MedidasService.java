package com.betrybe.agrotechmeasureshelter.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import com.betrybe.agrotechmeasureshelter.model.Measurements;
import com.betrybe.agrotechmeasureshelter.repository.MedidasRepository;

@ApplicationScoped
public class MedidasService {

  @Inject
  MedidasRepository medidasRepository;

  public List<Measurements> list() {
    List<Measurements> measurements = medidasRepository.listAll();
    return measurements;
  }

  public void add(Measurements measurements) {
    medidasRepository.persist(measurements);
  }
}
