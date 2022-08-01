package com.betrybe.agrotechmeasureshelter.Exception;

/**
 * Class ErrorMessage.
 */
public class ErrorMessage {

  private String message;

  public ErrorMessage(String message) {
    this.message = message;
  }

  /**
   * Return the message.
   */
  public String getMessage() {
    return message;
  }

  /**
   * Param message the message to set.
   */
  public void setMessage(String message) {
    this.message = message;
  }

}
