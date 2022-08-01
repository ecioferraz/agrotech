package com.betrybe.Exception;

public class NotFoundException extends Exception {

  private static final long serialVersionUID = -981103646271815514L;

  public NotFoundException() {
    super("Content not found!");
  }

}
