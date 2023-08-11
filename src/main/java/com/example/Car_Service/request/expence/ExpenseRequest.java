package com.example.Car_Service.request.expence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseRequest {
    private Long id;
    private String name;
    private LocalDate date;
    private Double price;
    private Long vehicleId;
    private String vinCode;


}
