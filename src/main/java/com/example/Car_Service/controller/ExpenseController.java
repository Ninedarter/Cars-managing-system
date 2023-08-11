package com.example.Car_Service.controller;


import com.example.Car_Service.request.expence.ExpenseRequest;
import com.example.Car_Service.response.ExpenseResponse;
import com.example.Car_Service.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenses")
@RequiredArgsConstructor
@Slf4j
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/add")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ExpenseResponse> addForSpecificVehicle(@RequestBody ExpenseRequest expenseRequest) {
        return ResponseEntity.ok(expenseService.addForSpecificVehicle(expenseRequest));
    }

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:4200/cars")
    public ResponseEntity<ExpenseResponse> getAll() {
        return ResponseEntity.ok(expenseService.getAll());
    }


    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:4200")
    ResponseEntity<ExpenseResponse> getByVinCode(@RequestParam(value = "vinCode") String vinCode) {
        try {
            ExpenseResponse response = expenseService.getByVinCode(vinCode);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("No maintenances were found");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void delete(@PathVariable Long id) {
        expenseService.delete(id);
    }

    @PutMapping("/")
    @CrossOrigin(origins = "http://localhost:4200")
    ResponseEntity<ExpenseResponse> update(@RequestBody ExpenseRequest request) {

        try {
            return ResponseEntity.ok(expenseService.update(request));
        } catch (Exception e) {
            log.error("Cannot update maintenance");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
