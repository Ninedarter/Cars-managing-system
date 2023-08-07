package com.example.Car_Service.service;

import com.example.Car_Service.model.Maintenance;
import com.example.Car_Service.model.Owner;
import com.example.Car_Service.model.Vehicle;
import com.example.Car_Service.repository.OwnerRepository;
import com.example.Car_Service.repository.VehicleRepository;
import com.example.Car_Service.request.maintenance.MaintenanceRequest;
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
       return  Vehicle.builder()
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

    public Maintenance mapMaintenance(MaintenanceRequest maintenanceRequest) {
        Vehicle vehicle = vehicleRepository.findByVinCode(maintenanceRequest.getVinCode())
                .orElseThrow(() -> new IllegalArgumentException("Vehicle not found"));
        Maintenance mappedMaintenance = Maintenance.builder()
                .id(maintenanceRequest.getId())
                .name(maintenanceRequest.getName())
                .date(maintenanceRequest.getDate())
                .price(maintenanceRequest.getPrice())
                .vehicle(vehicle)
                .build();
        return mappedMaintenance;
    }

}
