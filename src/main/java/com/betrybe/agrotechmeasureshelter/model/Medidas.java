package com.betrybe.agrotechmeasureshelter.model;

import java.time.LocalDateTime;

public class Medidas {

  private double temperatura;

  private double humidadeSolo;

  private double humidadeAr;

  private LocalDateTime instante = LocalDateTime.now();

  public Medidas() {}

  public Medidas(double temperatura, double humidadeSolo, double humidadeAr) {
    this.temperatura = temperatura;
    this.humidadeSolo = humidadeSolo;
    this.humidadeAr = humidadeAr;
  }

  public double getTemperatura() {
    return temperatura;
  }

  public void setTemperatura(double temperatura) {
    this.temperatura = temperatura;
  }

  public double getHumidadeSolo() {
    return humidadeSolo;
  }

  public void setHumidadeSolo(double humidadeSolo) {
    this.humidadeSolo = humidadeSolo;
  }

  public double getHumidadeAr() {
    return humidadeAr;
  }

  public void setHumidadeAr(double humidadeAr) {
    this.humidadeAr = humidadeAr;
  }

  public LocalDateTime getInstante() {
    return instante;
  }

  public void setInstante(LocalDateTime instante) {
    this.instante = instante;
  }
}
