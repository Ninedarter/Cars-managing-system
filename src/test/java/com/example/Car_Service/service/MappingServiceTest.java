package com.example.Car_Service.service;

import com.example.Car_Service.model.Expense;
import com.example.Car_Service.model.Owner;
import com.example.Car_Service.model.Vehicle;
import com.example.Car_Service.repository.OwnerRepository;
import com.example.Car_Service.repository.VehicleRepository;
import com.example.Car_Service.request.expence.ExpenseRequest;
import com.example.Car_Service.request.vehicle.VehicleRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class MappingServiceTest {

    @Mock
    private VehicleRepository vehicleRepository;
    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private MappingService mappingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldMapVehicleFromRequest() {

        VehicleRequest mockedRequest = VehicleRequest.builder()
                .email("tom@gmail.com")
                .brand("BMW")
                .mileage(2222)
                .technicalExpirationDate(LocalDate.of(2022, 02, 02))
                .build();

        Owner mockOwner = Owner.builder()
                .email("tom@gmail.com")
                .firstName("Tom")
                .build();
        when(ownerRepository.findByEmail("tom@gmail.com"))
                .thenReturn(Optional.of(mockOwner));

        Vehicle mappedVehicle = mappingService.mapVehicle(mockedRequest);
        assertEquals("BMW", mappedVehicle.getBrand());
        assertEquals(2222, mappedVehicle.getMileage());
        assertEquals("Tom", mappedVehicle.getOwner().getFirstName());
    }

    @Test
    void shouldMapMaintenanceFromRequest() {
        ExpenseRequest mockedRequest = ExpenseRequest.builder()
                .vinCode("ABC123")
                .name("Oil change")
                .price(20.0)
                .build();

        Vehicle mockedVehicle = Vehicle.builder()
                .vinCode("ABC123")
                .brand("Mazda")
                .yearOfMade(2020)
                .build();

        when(vehicleRepository.findByVinCode("ABC123")).thenReturn((mockedVehicle));
        Expense mappedExpense = mappingService.mapMaintenance(mockedRequest);

        assertEquals("Oil change", mappedExpense.getName());
        assertEquals(20.0, mappedExpense.getPrice());
        assertEquals("ABC123", mappedExpense.getVehicle().getVinCode());


    }
}


