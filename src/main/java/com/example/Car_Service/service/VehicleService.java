package com.example.Car_Service.service;

import com.example.Car_Service.model.Vehicle;
import com.example.Car_Service.repository.VehicleRepository;
import com.example.Car_Service.request.vehicle.VehicleRequest;
import com.example.Car_Service.response.VehicleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final MappingService mappingService;

    public VehicleResponse getAll() {
        return new VehicleResponse(vehicleRepository.findAll());
    }

    public VehicleResponse addNew(VehicleRequest vehicleRequest) {
        vehicleRepository.save(mappingService.mapVehicle(vehicleRequest));
        log.info("Vehicle " + vehicleRequest.getBrand() + " " + vehicleRequest.getModel() + " was added successfully");
        return new VehicleResponse(vehicleRepository.findVehiclesByEmail(vehicleRequest.getEmail()));
    }

    public VehicleResponse getAllByOwner(String email) {
        return new VehicleResponse(vehicleRepository.findVehiclesByEmail(email));
    }

    public void delete(Long id) {
        vehicleRepository.deleteById(id);
    }

    public VehicleResponse update(VehicleRequest request) {
        Vehicle existingVehicle = vehicleRepository.findByVinCode(request.getVinCode());
        Vehicle vehicleToUpdate = mappingService.mapVehicleByVinCode(existingVehicle, request);
        vehicleRepository.save(vehicleToUpdate);
        return new VehicleResponse(vehicleRepository.findVehiclesByEmail(request.getEmail()));
    }

    public Long getOwnerId(String email) {
        return vehicleRepository.findOwnerIdByEmail(email);
    }
}
