package com.betrybe.agrotechmeasureshelter.repository;

import javax.enterprise.context.ApplicationScoped;
import com.betrybe.agrotechmeasureshelter.model.Medidas;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

@ApplicationScoped
public class MedidasRepository implements PanacheMongoRepository<Medidas> {
}
