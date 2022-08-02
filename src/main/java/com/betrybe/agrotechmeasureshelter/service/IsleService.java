package com.betrybe.agrotechmeasureshelter.service;

import com.betrybe.agrotechmeasureshelter.exception.NotFoundException;
import com.betrybe.agrotechmeasureshelter.model.Isle;
import com.betrybe.agrotechmeasureshelter.model.Measurements;
import com.betrybe.agrotechmeasureshelter.repository.IsleRepository;
import org.bson.types.ObjectId;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import io.quarkus.scheduler.Scheduled;
import io.quarkus.scheduler.ScheduledExecution;

@ApplicationScoped
public class IsleService {

  @Inject
  MeasurementsService measurementsService;

  @Inject
  IsleRepository isleRepository;

  public List<Isle> list() {
    List<Isle> isles = isleRepository.listAll();
    return isles;
  }

  public void add(Isle isle) {
    isleRepository.persist(isle);
  }

  @Scheduled(every = "2s") // 5min = PT20M - "PT15M" -- parses as "15 minutes" (where a minute is 60
                           // seconds)
  public void createAutomatedMeasures() {
    List<Isle> getAllIsle = isleRepository.listAll();
    getAllIsle.stream().forEach(isle -> {
      String idIsle = isle.getId().toString();
      double temperature = 20;
      double soilHumidity = 25;
      double airHumidity = 45;
      Measurements newMeasurement =
          new Measurements(idIsle, temperature, soilHumidity, airHumidity);
      measurementsService.add(newMeasurement);
    });
  }


  public Isle findById(String id) throws NotFoundException {
    Isle isle = isleRepository.findById(new ObjectId(id));
    if (isle == null) {
      throw new NotFoundException();
    }
    return isle;
  }

  public Isle update(String id, Isle isle) throws NotFoundException {
    Isle isleToUpdate = findById(id);
    isleToUpdate.setName(isle.getName());
    isleToUpdate.setStatus(isle.getStatus());
    isleRepository.update(isleToUpdate);
    return isleToUpdate;
  }

  public void delete(String id) throws NotFoundException {
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
