package com.example.bms.repository.impl;

import com.example.bms.entity.Hospital;
import com.example.bms.repository.HospitalRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryHospitalRepository implements HospitalRepository {

    private final List<Hospital> hospitals = new ArrayList<>();

    @Override
    public Hospital save(Hospital hospital) {
        hospitals.add(hospital);
        return hospital;
    }

    @Override
    public List<Hospital> findAll() {
        return hospitals;
    }

    @Override
    public Optional<Hospital> findById(Long id) {
        return hospitals.stream()
                .filter(it -> it.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Hospital> findByName(String name) {
        return hospitals.stream()
                .filter(it -> it.getName().equals(name))
                .findFirst();
    }
}
