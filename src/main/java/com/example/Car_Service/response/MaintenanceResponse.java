package com.example.Car_Service.response;

import com.example.Car_Service.model.Maintenance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceResponse {

    private List<Maintenance> maintenances;

}
