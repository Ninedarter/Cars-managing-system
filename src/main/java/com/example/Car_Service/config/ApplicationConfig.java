package com.example.Car_Service.config;

import com.example.Car_Service.model.Maintenance;
import com.example.Car_Service.model.Owner;
import com.example.Car_Service.model.Vehicle;
import com.example.Car_Service.repository.MaintenanceRepository;
import com.example.Car_Service.repository.OwnerRepository;
import com.example.Car_Service.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.Filter;
import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {


    @Bean
    CommandLineRunner commandLineRunner(VehicleRepository vehicleRepository, OwnerRepository ownerRepository, MaintenanceRepository maintenanceRepository) {
        return args -> {
            Owner owner1 = Owner.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .age(30)
                    .email("pirmas@gmail.com")
                    .password(new BCryptPasswordEncoder().encode("pirmas"))
                    .build();

            ownerRepository.save(owner1);


            Vehicle vehicle1 = Vehicle.builder()
                    .brand("Toyota")
                    .model("Camry")
                    .yearOfMade(2020)
                    .horsePower(200)
                    .vinCode("ABC123XYZ456")
                    .originCountry("Japan")
                    .mileage(50000)
                    .technicalExpirationDate(LocalDate.of(2023, 12, 31))
                    .insuranceExpirationDate(LocalDate.of(2023, 12, 31))
                    .owner(owner1)
                    .build();


            vehicleRepository.save(vehicle1);


            Maintenance maintenance1 = Maintenance.builder()
                    .name("Oil Change")
                    .date(LocalDate.of(2022, 6, 15))
                    .price(50.0)
                    .vehicle(vehicle1)
                    .build();

            maintenanceRepository.save(maintenance1);

            Maintenance maintenance2 = Maintenance.builder()
                    .name("Brake Service")
                    .date(LocalDate.of(2022, 6, 25))
                    .price(100.0)
                    .vehicle(vehicle1)
                    .build();

            maintenanceRepository.save(maintenance2);


            Owner owner2 = Owner.builder()
                    .firstName("Jane")
                    .lastName("Smith")
                    .age(35)
                    .email("antras@gmail.com")
                    .password(new BCryptPasswordEncoder().encode("antras"))
                    .build();

            ownerRepository.save(owner2);


            Vehicle vehicle2_1 = Vehicle.builder()
                    .brand("Honda")
                    .model("Civic")
                    .yearOfMade(2018)
                    .horsePower(180)
                    .vinCode("DEF456UVW789")
                    .originCountry("Japan")
                    .mileage(60000)
                    .technicalExpirationDate(LocalDate.of(2024, 10, 31))
                    .insuranceExpirationDate(LocalDate.of(2024, 10, 31))
                    .owner(owner2)
                    .imgUrl("https://shorturl.at/pATUZ")
                    .build();

            vehicleRepository.save(vehicle2_1);

            Maintenance maintenance3 = Maintenance.builder()
                    .name("Oil Change")
                    .date(LocalDate.of(2022, 6, 10))
                    .price(60.0)
                    .vehicle(vehicle2_1)
                    .build();

            maintenanceRepository.save(maintenance3);

            Maintenance maintenance4 = Maintenance.builder()
                    .name("Tire Rotation")
                    .date(LocalDate.of(2022, 6, 20))
                    .price(80.0)
                    .vehicle(vehicle2_1)
                    .build();

            maintenanceRepository.save(maintenance4);

            Maintenance maintenance5 = Maintenance.builder()
                    .name("Brake Service")
                    .date(LocalDate.of(2022, 7, 5))
                    .price(100.0)
                    .vehicle(vehicle2_1)
                    .build();

            maintenanceRepository.save(maintenance5);

            Vehicle vehicle2_2 = Vehicle.builder()
                    .brand("Ford")
                    .model("Mustang")
                    .yearOfMade(2021)
                    .horsePower(300)
                    .vinCode("GHI789JKL123")
                    .originCountry("USA")
                    .mileage(20000)
                    .technicalExpirationDate(LocalDate.of(2025, 8, 31))
                    .insuranceExpirationDate(LocalDate.of(2025, 8, 31))
                    .owner(owner2)
                    .imgUrl("https://shorturl.at/gwEI5")
                    .build();

            vehicleRepository.save(vehicle2_2);

            Maintenance maintenance6 = Maintenance.builder()
                    .name("Oil Change")
                    .date(LocalDate.of(2022, 6, 5))
                    .price(50.0)
                    .vehicle(vehicle2_2)
                    .build();

            maintenanceRepository.save(maintenance6);

            Maintenance maintenance7 = Maintenance.builder()
                    .name("Brake Service")
                    .date(LocalDate.of(2022, 7, 15))
                    .price(120.0)
                    .vehicle(vehicle2_2)
                    .build();

            maintenanceRepository.save(maintenance7);

            Maintenance maintenance8 = Maintenance.builder()
                    .name("Oil Change")
                    .date(LocalDate.of(2022, 8, 10))
                    .price(50.0)
                    .vehicle(vehicle2_2)
                    .build();

            maintenanceRepository.save(maintenance8);

            Vehicle vehicle2_3 = Vehicle.builder()
                    .brand("Toyota")
                    .model("Rav4")
                    .yearOfMade(2019)
                    .horsePower(150)
                    .vinCode("MNO123PQR456")
                    .originCountry("Japan")
                    .mileage(35000)
                    .technicalExpirationDate(LocalDate.of(2023, 12, 31))
                    .insuranceExpirationDate(LocalDate.of(2023, 12, 31))
                    .owner(owner2)
                    .imgUrl("https://shorturl.at/amnEH")
                    .build();

            vehicleRepository.save(vehicle2_3);

            Maintenance maintenance9 = Maintenance.builder()
                    .name("Oil Change")
                    .date(LocalDate.of(2022, 9, 5))
                    .price(50.0)
                    .vehicle(vehicle2_3)
                    .build();

            maintenanceRepository.save(maintenance9);
            Owner owner3 = Owner.builder()
                    .firstName("Michael")
                    .lastName("Johnson")
                    .age(40)
                    .email("trecias@gmail.com")
                    .password(new BCryptPasswordEncoder().encode("trecias"))
                    .build();

            ownerRepository.save(owner3);

            Vehicle vehicle3_1 = Vehicle.builder()
                    .brand("BMW")
                    .model("X5")
                    .yearOfMade(2022)
                    .horsePower(250)
                    .vinCode("STU789VWX123")
                    .originCountry("Germany")
                    .mileage(15000)
                    .technicalExpirationDate(LocalDate.of(2024, 12, 31))
                    .insuranceExpirationDate(LocalDate.of(2024, 12, 31))
                    .owner(owner3)
                    .build();

            vehicleRepository.save(vehicle3_1);

            Maintenance maintenance10 = Maintenance.builder()
                    .name("Oil Change")
                    .date(LocalDate.of(2022, 10, 5))
                    .price(50.0)
                    .vehicle(vehicle3_1)
                    .build();

            maintenanceRepository.save(maintenance10);

            Maintenance maintenance11 = Maintenance.builder()
                    .name("Brake Service")
                    .date(LocalDate.of(2022, 11, 10))
                    .price(100.0)
                    .vehicle(vehicle3_1)
                    .build();

            maintenanceRepository.save(maintenance11);

            Vehicle vehicle3_2 = Vehicle.builder()
                    .brand("Mercedes-Benz")
                    .model("C-Class")
                    .yearOfMade(2020)
                    .horsePower(220)
                    .vinCode("YZA123BCD456")
                    .originCountry("Germany")
                    .mileage(25000)
                    .technicalExpirationDate(LocalDate.of(2023, 10, 31))
                    .insuranceExpirationDate(LocalDate.of(2023, 10, 31))
                    .owner(owner3)
                    .build();

            vehicleRepository.save(vehicle3_2);
            Maintenance maintenance12 = Maintenance.builder()
                    .name("Oil Change")
                    .date(LocalDate.of(2022, 10, 15))
                    .price(50.0)
                    .vehicle(vehicle3_2)
                    .build();

            maintenanceRepository.save(maintenance12);

            Maintenance maintenance13 = Maintenance.builder()
                    .name("Brake Service")
                    .date(LocalDate.of(2022, 11, 20))
                    .price(100.0)
                    .vehicle(vehicle3_2)
                    .build();

            maintenanceRepository.save(maintenance13);

        };
    }

    private final OwnerRepository ownerRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> ownerRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}

