package com.betrybe.agrotechmeasureshelter.test;

import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import java.awt.List;

@QuarkusTest
public class MeasurementsResourceTest {

  @Test
  public void testSuccesfulGetRequest() {
    given().when().get("/medidas").then().statusCode(200).body(is(new List()));
  }
}
