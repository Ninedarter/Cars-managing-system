package com.example.Car_Service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate date;
    private Double price;


    int [] masyvas = new int[2];    
    int masyvas2[];
    @ManyToOne
    @JoinColumn(name = "vehicleId")
    private Vehicle vehicle;


}
