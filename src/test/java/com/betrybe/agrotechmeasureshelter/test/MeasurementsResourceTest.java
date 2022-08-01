package com.betrybe.agrotechmeasureshelter.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.betrybe.agrotechmeasureshelter.model.Measurements;
import com.betrybe.agrotechmeasureshelter.service.MeasurementsService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.QuarkusMock;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import java.util.List;
import java.util.ArrayList;
import javax.inject.Inject;

@QuarkusTest
public class MeasurementsResourceTest {

  @Inject
  MeasurementsService measurementsService;

  @BeforeAll
  public static void setup() {
    List<Measurements> mockList = new ArrayList<Measurements>();
    MeasurementsService mockService = Mockito.mock(MeasurementsService.class);
    Mockito.when(mockService.list()).thenReturn(mockList);
    QuarkusMock.installMockForType(mockService, MeasurementsService.class);
  }

  @Test
  public void testSuccesfulGetRequest() {
    List<Measurements> emptyList = new ArrayList<Measurements>();
    given().when().get("/medidas").then().statusCode(200).body(is(emptyList));
  }
}
