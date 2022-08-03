package com.betrybe.agrotechmeasureshelter.test.service;

import static org.mockito.Mockito.times;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import com.betrybe.agrotechmeasureshelter.Exception.NotFoundException;
import com.betrybe.agrotechmeasureshelter.model.Isle;
import com.betrybe.agrotechmeasureshelter.repository.IsleRepository;
import com.betrybe.agrotechmeasureshelter.service.IsleService;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class IsleServiceTest {

  @Inject
  IsleService isleService;

  @InjectMock
  IsleRepository isleRepository;

  @BeforeAll
  public static void setup() {
    List<Isle> mockList = new ArrayList<Isle>();
    Isle southIsle = new Isle("South Isle", true);
    mockList.add(southIsle);
    IsleRepository mockRepository = Mockito.mock(IsleRepository.class);
    Mockito.doNothing().when(mockRepository).persist(Mockito.any(Isle.class));
    Mockito.when(mockRepository.listAll()).thenReturn(mockList);
    Mockito.when(mockRepository.findById(new ObjectId("62ead48515906f4f3f529240")))
        .thenReturn(southIsle);
    Mockito.when(mockRepository.count()).thenReturn((long) 1);
    QuarkusMock.installMockForType(mockRepository, IsleRepository.class);
  }

  @Test
  public void testListAllIsle() {
    List<Isle> emptyList = isleService.list();
    Assertions.assertTrue(emptyList.size() == 0);
  }

  @Test
  public void testCreateIsle() {
    Isle mockMeasurement = new Isle("Ilha Sul", true);
    isleService.add(mockMeasurement);
    Mockito.verify(isleRepository, times(1)).persist(mockMeasurement);
  }

  // @Test
  // public void testFindById() throws NotFoundException {
  // Isle southIsle = new Isle("South Isle", true);
  // // Isle findIsle = isleService.findById("62ead48515906f4f3f529240");
  // Assertions.assertEquals("{\"message\": \"Content not found\"}",
  // isleRepository.findById(new ObjectId("62ead48515906f4f3f529240")));
  // }

  @Test
  public void testSearchIsle() {
    Isle newIsle = new Isle("Ilha", true);
    Mockito.when(isleRepository.findByName("Ilha")).thenReturn(newIsle);
    Assertions.assertEquals(newIsle, isleRepository.findByName("Ilha"));
  }

  @Test
  public void testDropDatabaseIsle() {
    Mockito.when(isleRepository.deleteAll()).thenReturn(0L);
    Assertions.assertEquals(0, isleRepository.count());
  }

  @Test
  public void testCountIsle() {
    Mockito.when(isleRepository.count()).thenReturn(23L);
    Assertions.assertEquals(23, isleRepository.count());
  }
}
