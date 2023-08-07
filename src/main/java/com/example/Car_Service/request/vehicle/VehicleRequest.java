package com.example.Car_Service.request.vehicle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleRequest {

    private String brand;
    private String model;
    private Integer yearOfMade;
    private Integer horsePower;
    private String vinCode;
    private String originCountry;
    private Integer mileage;
    private LocalDate technicalExpirationDate;
    private LocalDate insuranceExpirationDate;
    private String email;
    private String imgUrl;

}
