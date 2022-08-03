package com.betrybe.agrotechmeasureshelter.util;

import java.util.Random;

public class RandomMeasures {

  private Double temperature = generateRandomTemperature();

  private Double soilHumidity = generateRandomHumidity();

  private Double airHumidity = generateRandomHumidity();

  public RandomMeasures() {}

  /**
   * Método para gerar temperatura aleatoriamente entre 1 a 45.
   */
  public Double generateRandomTemperature() {
    Random r = new Random();
    double randomValue = 1 + (45 - 1) * r.nextDouble();

    return randomValue;
  }

  /**
   * Método para gerar humidade do ar / solo aleatoriamente entre 0 a 100.
   */
  public Double generateRandomHumidity() {
    Random r = new Random();
    double randomValue = 0 + (100 - 0) * r.nextDouble();

    return randomValue;
  }

  /**
   * Retorna a temperatura.
   */
  public Double getTemperature() {
    return temperature;
  }

  /**
   * Retorna a humidade do solo.
   */
  public Double getSoilHumidity() {
    return soilHumidity;
  }

  /**
   * Retorna a humidade do ar.
   */
  public Double getAirHumidity() {
    return airHumidity;
  }

}
