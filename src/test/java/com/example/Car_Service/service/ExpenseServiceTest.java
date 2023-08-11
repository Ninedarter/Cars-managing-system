package com.example.Car_Service.service;

import com.example.Car_Service.model.Expense;
import com.example.Car_Service.model.Vehicle;
import com.example.Car_Service.repository.VehicleRepository;
import com.example.Car_Service.response.ExpenseResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ExpenseServiceTest {

    @Mock
    private VehicleRepository vehicleRepository;


    @InjectMocks
    private ExpenseService expenseService;

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

        Expense mockedExpense1 = Expense.builder()
                .id(1L)
                .name("Oil change")
                .vehicle(mockedVehicle1).
                build();

        Expense mockedExpense2 = Expense.builder()
                .id(2L)
                .name("Brake change")
                .vehicle(mockedVehicle1).
                build();

        mockedVehicle1.setExpenses(Arrays.asList(mockedExpense1, mockedExpense2));

        Vehicle mockedVehicle2 = Vehicle.builder()
                .id(2L)
                .vinCode("QWERTY")
                .yearOfMade(2018)
                .build();

        Expense mockedExpense3 = Expense.builder()
                .id(3L)
                .name("Oil and filter change")
                .vehicle(mockedVehicle1).
                build();

        mockedVehicle2.setExpenses(Arrays.asList(mockedExpense3));

        when(vehicleRepository.findByVinCode("ABC123")).thenReturn((mockedVehicle1));
        ExpenseResponse response = expenseService.getByVinCode("ABC123");

        assertEquals(2, response.getExpenses().size());
        assertEquals(2015, response.getExpenses().get(0).getVehicle().getYearOfMade());
        assertEquals("Brake change", response.getExpenses().get(1).getName());
    }

}