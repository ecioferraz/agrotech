package com.betrybe.agrotechmeasureshelter.test.resource;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.betrybe.agrotechmeasureshelter.model.Isle;
import com.betrybe.agrotechmeasureshelter.service.IsleService;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class IsleResourceTest {

  @Inject
  IsleService isleService;

  @BeforeAll
  public static void setup() {
    List<Isle> mockList = new ArrayList<Isle>();
    Isle mockIsle = new Isle();
    IsleService mockService = Mockito.mock(IsleService.class);
    Mockito.when(mockService.list()).thenReturn(mockList);
    Mockito.doNothing().when(mockService).add(mockIsle);
    QuarkusMock.installMockForType(mockService, IsleService.class);
  }

  @Test
  public void testSuccesfulGetRequest() {
    given().when().get("/isle").then().statusCode(200).body(containsString("[]"));
  }
}
