package com.example.Car_Service.controller;


import com.example.Car_Service.request.maintenance.MaintenanceRequest;
import com.example.Car_Service.response.MaintenanceResponse;
import com.example.Car_Service.service.MaintenanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maintenances")
@RequiredArgsConstructor
@Slf4j
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    @PostMapping("/add")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<MaintenanceResponse> addForSpecificVehicle(@RequestBody MaintenanceRequest maintenanceRequest) {
        return ResponseEntity.ok(maintenanceService.addForSpecificVehicle(maintenanceRequest));
    }

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:4200/cars")
    public ResponseEntity<MaintenanceResponse> getAll() {
        return ResponseEntity.ok(maintenanceService.getAll());
    }


    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:4200")
    ResponseEntity<MaintenanceResponse> getByVinCode(@RequestParam(value = "vinCode", required = true) String vinCode) {
        try {
            MaintenanceResponse response = maintenanceService.getByVinCode(vinCode);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("No maintenances were found");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void delete(@PathVariable Long id) {
        maintenanceService.delete(id);
    }

    @PutMapping("/")
    @CrossOrigin(origins = "http://localhost:4200")
    ResponseEntity<MaintenanceResponse> update(@RequestBody MaintenanceRequest request) {

        try {
            return ResponseEntity.ok(maintenanceService.update(request));
        } catch (Exception e) {
            log.error("Cannot update maintenance");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
