package com.example.Car_Service.service;

import com.example.Car_Service.model.Expense;
import com.example.Car_Service.model.Vehicle;
import com.example.Car_Service.repository.ExpenseRepository;
import com.example.Car_Service.repository.VehicleRepository;
import com.example.Car_Service.request.expence.ExpenseRequest;
import com.example.Car_Service.response.ExpenseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final MappingService mappingService;
    private final VehicleRepository vehicleRepository;

    public ExpenseResponse getAll() {
        return new ExpenseResponse(expenseRepository.findAll());
    }

    public ExpenseResponse addForSpecificVehicle(ExpenseRequest request) {
        Expense expenseToAdd = mappingService.mapMaintenance(request);
        expenseRepository.save(expenseToAdd);
        return new ExpenseResponse(expenseRepository.findByVehicleId(request.getVehicleId()));
    }

    public ExpenseResponse getByVinCode(final String vinCode) {
        final Vehicle vehicle = vehicleRepository.findByVinCode(vinCode);
        return new ExpenseResponse(vehicle.getExpenses());
    }

    public void delete(Long id) {
        expenseRepository.deleteById(id);
    }

    public ExpenseResponse update(ExpenseRequest request) {
        Expense expenseToUpdate = mappingService.mapMaintenance(request);
        expenseRepository.save(expenseToUpdate);
        return new ExpenseResponse(expenseRepository.findAll());
    }
}
