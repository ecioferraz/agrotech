package com.betrybe.agrotechmeasureshelter.repository;

import javax.enterprise.context.ApplicationScoped;
import com.betrybe.agrotechmeasureshelter.model.Measurements;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

@ApplicationScoped
public class MeasurementsRepository implements PanacheMongoRepository<Measurements> {
}
