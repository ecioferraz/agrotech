package com.betrybe.agrotechmeasureshelter.test.resource;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.betrybe.agrotechmeasureshelter.Exception.NotFoundException;
import com.betrybe.agrotechmeasureshelter.model.Isle;
import com.betrybe.agrotechmeasureshelter.service.IsleService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class IsleResourceTest {

  @InjectMock
  IsleService isleService;

  private Isle mockIsle;

  @BeforeEach
  public void setup() throws NotFoundException {
    List<Isle> mockList = new ArrayList<Isle>();
    mockIsle = new Isle();
    mockIsle.setName("South Isle");
    mockIsle.setStatus(true);
    mockList.add(mockIsle);
  }

  @Test
  public void testSuccessfulGetRequest() {
    Mockito.when(isleService.list()).thenReturn(List.of());
    given().when().get("/isle").then().statusCode(200).body(containsString("[]"));
  }

  @Test
  public void testSuccessfulGetByIdRequest() throws NotFoundException {
    Mockito.when(isleService.findById("62ead48515906f4f3f529240")).thenReturn(mockIsle);
    given().when().get("/isle/62ead48515906f4f3f529240").then().statusCode(200);
  }

  @Test
  public void testSuccessfullAddIsle() {
    Isle newIsle = new Isle();
    newIsle.setName("North Island");
    newIsle.setStatus(true);
    Mockito.doNothing().when(isleService).add(newIsle);
    given().contentType("application/json").body(newIsle).when().post("/isle").then()
        .statusCode(200);
  }

  @Test
  public void testSuccessfullUpdate() throws NotFoundException {
    Isle mockIsle = new Isle();
    Mockito.when(isleService.update("62ead48515906f4f3f529240", mockIsle)).thenReturn(mockIsle);
    given().body(mockIsle).header("Content-Type", "application/json").when().put("/isle/blablabla")
        .then().statusCode(204);
  }

  @Test
  public void testSuccessfullCountIsle() {
    Mockito.when(isleService.count()).thenReturn(1L);
    given().when().get("/isle/count").then().statusCode(200).body(containsString("1"));
  }

  @Test
  public void testSuccessfullDropDatabase() {
    Mockito.doNothing().when(isleService).dropDatabase();
    given().when().get("/isle/drop").then().statusCode(204).body(containsString(""));
  }

  @Test
  public void testSuccessfullSearchIsleByName() {
    mockIsle = new Isle();
    mockIsle.setName("South Isle");
    mockIsle.setStatus(true);
    Mockito.when(isleService.search("Ilha Sul")).thenReturn(mockIsle);
    given().when().get("/isle/search/Ilha Sul").then().statusCode(200)
        .body(containsString("{\"id\":null,\"name\":\"South Isle\",\"status\":true}"));
  }

  @Test
  public void testSuccessfullDeleteIsle() throws NotFoundException {
    Mockito.doNothing().when(isleService).delete("62ead48515906f4f3f529240");
    given().when().delete("/isle/62ead48515906f4f3f529240").then().statusCode(204);
  }
}
