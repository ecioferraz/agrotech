package com.betrybe.agrotechmeasureshelter.test.resource;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.betrybe.agrotechmeasureshelter.Exception.NotFoundException;
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
  public static void setup() throws NotFoundException {
    List<Isle> mockList = new ArrayList<Isle>();
    Isle mockIsle = new Isle("Ilha Norte", true);
    // mockList.add(mockIsle);
    IsleService mockService = Mockito.mock(IsleService.class);
    Mockito.when(mockService.list()).thenReturn(mockList);
    Mockito.doNothing().when(mockService).add(mockIsle);
    Mockito.doNothing().when(mockService).delete("null");
    Mockito.when(mockService.update("blablabla", mockIsle)).thenReturn(mockIsle);
    Mockito.when(mockService.findById(Mockito.anyString())).thenReturn(mockIsle);
    Isle mockSouthIsle = new Isle("Ilha Sul", true);
    Mockito.when(mockService.search("Ilha Sul")).thenReturn(mockSouthIsle);
    QuarkusMock.installMockForType(mockService, IsleService.class);
  }

  @Test
  public void testSuccessfulGetRequest() {
    given().when().get("/isle").then().statusCode(200).body(containsString("[]"));
  }

  @Test
  public void testSuccessfulGetByIdRequest() {
    given().when().get("/isle/blablabla").then().statusCode(200)
        .body(containsString("{\"id\":null,\"name\":\"Ilha Norte\",\"status\":true}"));
  }

  @Test
  public void testSuccessfullAddIsle() {
    var newIsle = new Isle("Ilha Sul", true);
    given().contentType("application/json").body(newIsle).when().post("/isle").then()
        .statusCode(200);
  }

  @Test
  public void testSuccessfullUpdate() {
    Isle mockIsle = new Isle();
    given().body(mockIsle).header("Content-Type", "application/json").when().put("/isle/blablabla")
        .then().statusCode(204);
  }

  @Test
  public void testSuccessfullCountIsle() {
    given().when().get("/isle/count").then().statusCode(200).body(containsString("0"));
  }

  @Test
  public void testSuccessfullDropDatabase() {
    given().when().get("/isle/drop").then().statusCode(204).body(containsString(""));
  }

  @Test
  public void testSuccessfullSearchIsleByName() {
    given().when().get("/isle/search/Ilha Sul").then().statusCode(200)
        .body(containsString("{\"id\":null,\"name\":\"Ilha Sul\",\"status\":true}"));
  }

  @Test
  public void testSuccessfullDeleteIsle() {
    given().when().delete("/isle/null").then().statusCode(204);
  }
}
