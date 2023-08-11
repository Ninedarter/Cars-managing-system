package com.example.Car_Service.service;

import com.example.Car_Service.model.Expense;
import com.example.Car_Service.model.Owner;
import com.example.Car_Service.model.Vehicle;
import com.example.Car_Service.repository.OwnerRepository;
import com.example.Car_Service.repository.VehicleRepository;
import com.example.Car_Service.request.expence.ExpenseRequest;
import com.example.Car_Service.request.vehicle.VehicleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MappingService {

    private final OwnerRepository ownerRepository;
    private final VehicleRepository vehicleRepository;

    public Vehicle mapVehicle(VehicleRequest vehicleRequest) {
        Owner owner = ownerRepository.findByEmail(vehicleRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Owner not found"));
        return Vehicle.builder()
                .brand(vehicleRequest.getBrand())
                .model(vehicleRequest.getModel())
                .yearOfMade(vehicleRequest.getYearOfMade())
                .vinCode(vehicleRequest.getVinCode())
                .originCountry(vehicleRequest.getOriginCountry())
                .mileage(vehicleRequest.getMileage())
                .horsePower(vehicleRequest.getHorsePower())
                .technicalExpirationDate(vehicleRequest.getTechnicalExpirationDate())
                .insuranceExpirationDate(vehicleRequest.getInsuranceExpirationDate())
                .owner(owner)
                .imgUrl(vehicleRequest.getImgUrl())
                .build();

    }


    public Vehicle mapVehicleByVinCode(Vehicle vehicleToUpdate, VehicleRequest request) {
        vehicleToUpdate.setMileage(request.getMileage());
        vehicleToUpdate.setTechnicalExpirationDate(request.getTechnicalExpirationDate());
        vehicleToUpdate.setInsuranceExpirationDate(request.getInsuranceExpirationDate());
        vehicleToUpdate.setImgUrl(request.getImgUrl());
        return vehicleToUpdate;

    }

    public Expense mapMaintenance(ExpenseRequest expenseRequest) {
        Vehicle vehicle = vehicleRepository.findByVinCode(expenseRequest.getVinCode());
        Expense mappedExpense = Expense.builder()
                .id(expenseRequest.getId())
                .name(expenseRequest.getName())
                .date(expenseRequest.getDate())
                .price(expenseRequest.getPrice())
                .vehicle(vehicle)
                .build();
        return mappedExpense;
    }

}
