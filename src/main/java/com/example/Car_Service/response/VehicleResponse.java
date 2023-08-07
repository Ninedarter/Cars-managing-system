package com.example.Car_Service.response;

import com.example.Car_Service.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleResponse {
    private List<Vehicle> vehicles;

}
