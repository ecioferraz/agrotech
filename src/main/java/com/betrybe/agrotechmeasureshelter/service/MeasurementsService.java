package com.betrybe.agrotechmeasureshelter.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import com.betrybe.agrotechmeasureshelter.model.Measurements;
import com.betrybe.agrotechmeasureshelter.repository.MeasurementsRepository;

@ApplicationScoped
public class MeasurementsService {

  @Inject
  MeasurementsRepository measurementsRepository;

  public List<Measurements> list() {
    List<Measurements> measurements = measurementsRepository.listAll();
    return measurements;
  }

  public Measurements add(Measurements measurements) {
    measurementsRepository.persist(measurements);
    return measurements;
  }
}
