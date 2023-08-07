package com.example.Car_Service.repository;

import com.example.Car_Service.model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance,Long> {

    List<Maintenance> findByVehicleId(Long vehicleId);

}
