package com.example.Car_Service.controller;

import com.example.Car_Service.request.vehicle.VehicleRequest;
import com.example.Car_Service.response.VehicleResponse;
import com.example.Car_Service.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor

public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping("/add")
    public ResponseEntity<VehicleResponse> addNew(@RequestBody VehicleRequest vehicleRequest) {
        return ResponseEntity.ok(vehicleService.addNew(vehicleRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<VehicleResponse> getAll() {
        return ResponseEntity.ok(vehicleService.getAll());
    }

    @GetMapping("/owner")
    public ResponseEntity<VehicleResponse> getAllByOwner(@RequestParam String email) {
        return ResponseEntity.ok(vehicleService.getAllByOwner(email));
    }

    @GetMapping("/owner/id")
    public ResponseEntity<Long> getOwnerId(@RequestParam String email) {
        return ResponseEntity.ok(vehicleService.getOwnerId(email));
    }

    @PutMapping("/")
    ResponseEntity<VehicleResponse> update(@RequestBody VehicleRequest vehicleRequest) {
        return ResponseEntity.ok(vehicleService.update(vehicleRequest));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        vehicleService.delete(id);

    }

}
