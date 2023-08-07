package com.example.Car_Service.service;

import com.example.Car_Service.model.Maintenance;
import com.example.Car_Service.model.Vehicle;
import com.example.Car_Service.repository.MaintenanceRepository;
import com.example.Car_Service.repository.VehicleRepository;
import com.example.Car_Service.response.MaintenanceResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class MaintenanceServiceTest {

    @Mock
    private VehicleRepository vehicleRepository;


    @InjectMocks
    private MaintenanceService maintenanceService;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldFindAllMaintenancesByGivenVinCode() {

        Vehicle mockedVehicle1 = Vehicle.builder()
                .id(1L)
                .vinCode("ABC123")
                .yearOfMade(2015)
                .build();

        Maintenance mockedMaintenance1 = Maintenance.builder()
                .id(1L)
                .name("Oil change")
                .vehicle(mockedVehicle1).
                build();

        Maintenance mockedMaintenance2 = Maintenance.builder()
                .id(2L)
                .name("Brake change")
                .vehicle(mockedVehicle1).
                build();

        mockedVehicle1.setMaintenances(Arrays.asList(mockedMaintenance1, mockedMaintenance2));

        Vehicle mockedVehicle2 = Vehicle.builder()
                .id(2L)
                .vinCode("QWERTY")
                .yearOfMade(2018)
                .build();

        Maintenance mockedMaintenance3 = Maintenance.builder()
                .id(3L)
                .name("Oil and filter change")
                .vehicle(mockedVehicle1).
                build();

        mockedVehicle2.setMaintenances(Arrays.asList(mockedMaintenance3));

        when(vehicleRepository.findByVinCode("ABC123")).thenReturn(Optional.of(mockedVehicle1));
        MaintenanceResponse response = maintenanceService.getByVinCode("ABC123");

        assertEquals(2, response.getMaintenances().size());
        assertEquals(2015, response.getMaintenances().get(0).getVehicle().getYearOfMade());
        assertEquals("Brake change", response.getMaintenances().get(1).getName());
    }

}