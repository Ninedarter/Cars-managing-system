package com.example.Car_Service.service;

import com.example.Car_Service.model.Maintenance;
import com.example.Car_Service.model.Vehicle;
import com.example.Car_Service.repository.MaintenanceRepository;
import com.example.Car_Service.repository.VehicleRepository;
import com.example.Car_Service.request.maintenance.MaintenanceRequest;
import com.example.Car_Service.response.MaintenanceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;
    private final MappingService mappingService;
    private final VehicleRepository vehicleRepository;

    public MaintenanceResponse getAll() {
        return new MaintenanceResponse(maintenanceRepository.findAll());
    }

    public MaintenanceResponse addForSpecificVehicle(MaintenanceRequest request) {
        Maintenance maintenanceToAdd = mappingService.mapMaintenance(request);
        maintenanceRepository.save(maintenanceToAdd);
        return new MaintenanceResponse(maintenanceRepository.findByVehicleId(request.getVehicleId()));
    }

    public MaintenanceResponse getByVinCode(final String vinCode) {
        final Optional<Vehicle> vehicle = vehicleRepository.findByVinCode(vinCode);
        return new MaintenanceResponse(vehicle.get().getMaintenances());
    }

    public void delete(Long id) {
        maintenanceRepository.deleteById(id);
    }

    public MaintenanceResponse update(MaintenanceRequest request) {
        Maintenance maintenanceToUpdate = mappingService.mapMaintenance(request);
        maintenanceRepository.save(maintenanceToUpdate);
        return new MaintenanceResponse(maintenanceRepository.findAll());
    }
}
