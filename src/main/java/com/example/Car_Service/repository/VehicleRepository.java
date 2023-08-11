package com.example.Car_Service.repository;

import com.example.Car_Service.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {


    @Query("SELECT v FROM Vehicle v WHERE v.owner.email = :email")
    List<Vehicle> findVehiclesByEmail(@Param("email") String email);
    @Query("SELECT o.id FROM Owner o WHERE o.email = :email")
    Long findOwnerIdByEmail(@Param("email") String email);
    Vehicle findByVinCode(String vinCode);


}
