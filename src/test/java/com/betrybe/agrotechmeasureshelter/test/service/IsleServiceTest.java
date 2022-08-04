package com.betrybe.agrotechmeasureshelter.test.service;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import com.betrybe.agrotechmeasureshelter.Exception.NotFoundException;
import com.betrybe.agrotechmeasureshelter.model.Isle;
import com.betrybe.agrotechmeasureshelter.repository.IsleRepository;
import com.betrybe.agrotechmeasureshelter.service.IsleService;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class IsleServiceTest {

  @Inject
  IsleService isleService;

  @InjectMock
  IsleRepository isleRepository;

  private Isle isle;

  @BeforeEach
  public void setup() {
    isle = new Isle();
    isle.setName("South Isle");
    isle.setStatus(true);
  }

  @Test
  public void testListAllIsle() {
    List<Isle> isleList = new ArrayList<Isle>();
    isleList.add(isle);
    Mockito.when(isleRepository.listAll()).thenReturn(isleList);

    Assertions.assertTrue(isleService.list() == isleList);

  }

  @Test
  public void testCreateIsle() {
    Mockito.doNothing().when(isleRepository).persist(Mockito.any(Isle.class));

    List<Isle> isleList = new ArrayList<Isle>();
    isleList.add(isle);

    Isle newIsle = new Isle("North Island", true);
    isleList.add(newIsle);
    isleService.add(newIsle);

    Assertions.assertEquals(2, isleList.size());
  }

  @Test
  public void testDeleteIsle() throws NotFoundException {
    List<Isle> isleList = new ArrayList<Isle>();
    isleList.add(isle);

    Mockito.doNothing().when(isleRepository).delete(Mockito.any(Isle.class));

    Mockito.when(isleRepository.findById(new ObjectId("62ead48515906f4f3f529240")))
        .thenReturn(isleList.get(0));
    isleService.delete("62ead48515906f4f3f529240");
    isleList.remove(0);

    Mockito.when(isleRepository.count()).thenReturn((long) isleList.size());
    Assertions.assertEquals(0, isleService.count());
  }

  @Test
  public void testFindByIdIsle() throws NotFoundException {
    List<Isle> isleList = new ArrayList<Isle>();
    isleList.add(isle);

    Mockito.when(isleRepository.findById(new ObjectId("62ead48515906f4f3f529240")))
        .thenReturn(isleList.get(0));

    Mockito.when(isleRepository.count()).thenReturn((long) isleList.size());
    Assertions.assertEquals(1, isleService.count());
  }

  @Test
  public void testSearchIsle() {
    Isle newIsle = new Isle("Ilha", true);
    Mockito.when(isleRepository.findByName("Ilha")).thenReturn(newIsle);
    Assertions.assertEquals(newIsle, isleService.search("Ilha"));
  }

  @Test
  public void testDropDatabaseIsle() {
    List<Isle> isleList = new ArrayList<Isle>();
    isleList.add(isle);
    Mockito.when(isleRepository.count()).thenReturn((long) isleList.size());
    Assertions.assertEquals(1, isleService.count());

    Mockito.when(isleRepository.deleteAll()).thenReturn(0L);
    isleService.dropDatabase();
    isleList.clear();
    Mockito.when(isleRepository.listAll()).thenReturn(isleList);
    List<Isle> findIsles = isleService.list();
    Assertions.assertTrue(findIsles.isEmpty());
  }

  @Test
  public void testCountIsle() {
    Mockito.when(isleRepository.count()).thenReturn(23L);
    Assertions.assertEquals(23, isleService.count());
  }
}
