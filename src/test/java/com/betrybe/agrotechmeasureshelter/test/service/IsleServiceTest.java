package com.betrybe.agrotechmeasureshelter.test.service;

import static org.mockito.Mockito.times;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import com.betrybe.agrotechmeasureshelter.model.Isle;
import com.betrybe.agrotechmeasureshelter.repository.IsleRepository;
import com.betrybe.agrotechmeasureshelter.service.IsleService;
import com.mongodb.assertions.Assertions;
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
    IsleRepository mockRepository = Mockito.mock(IsleRepository.class);
    Mockito.doNothing().when(mockRepository).persist(Mockito.any(Isle.class));
    Mockito.when(mockRepository.listAll()).thenReturn(mockList);
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
}
