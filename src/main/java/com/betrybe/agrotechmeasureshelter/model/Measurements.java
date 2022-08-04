package com.betrybe.agrotechmeasureshelter.model;

import java.time.LocalDateTime;
import javax.inject.Inject;
import org.bson.types.ObjectId;
import com.betrybe.agrotechmeasureshelter.repository.IsleRepository;

public class Measurements {

  @Inject
  IsleRepository repository;

  public ObjectId idIsle;

  private String isleName;

  private double temperature;

  private double soilHumidity;

  private double airHumidity;

  private LocalDateTime measuredAt = LocalDateTime.now();

  public Measurements() {}

  public Measurements(String idIsle, double temperature, double soilHumidity, double airHumidity) {
    this.idIsle = new ObjectId(idIsle);
    this.temperature = temperature;
    this.soilHumidity = soilHumidity;
    this.airHumidity = airHumidity;
    try {
      this.isleName = repository.findById(this.idIsle).getName();
    } catch (NullPointerException np) {
      this.isleName = "ilha_test_0";
    }
  }

  public String getIsleName() {
    return isleName;
  }

  public void setIsleName(String isleName) {
    this.isleName = isleName;
  }

  public ObjectId getIdIsle() {
    return idIsle;
  }

  public void setIdIsle(ObjectId idIsle) {
    this.idIsle = idIsle;
  }

  public double getTemperature() {
    return temperature;
  }

  public void setTemperature(double temperature) {
    this.temperature = temperature;
  }

  public double getSoilHumidity() {
    return soilHumidity;
  }

  public void setSoilHumidity(double soilHumidity) {
    this.soilHumidity = soilHumidity;
  }

  public double getAirHumidity() {
    return airHumidity;
  }

  public void setAirHumidity(double airHumidity) {
    this.airHumidity = airHumidity;
  }

  public LocalDateTime getMeasuredAt() {
    return measuredAt;
  }

  public void setMeasuredAt(LocalDateTime measuredAt) {
    this.measuredAt = measuredAt;
  }

}
