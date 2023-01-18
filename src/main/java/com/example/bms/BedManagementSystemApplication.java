package com.example.bms;

import com.example.bms.entity.Hospital;
import com.example.bms.repository.HospitalRepository;
import com.example.bms.service.BMSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BedManagementSystemApplication {

    @Autowired
    private HospitalRepository hospitalRepository;

    public static void main(String[] args) {
        SpringApplication.run(BedManagementSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            List<Hospital> hospitals = List.of(
                    new Hospital(
                            "c34b096b-d5d0-4762-8608-0d1037438b26",
                            "ABC Hospital",
                            "A-123, DEF Street, India - 123456",
                            "9999999999",
                            300,
                            null
                    )
            );

            hospitals.forEach(hospitalRepository::save);
        };
    }
}
