package com.example.bms.repository;

import com.example.bms.entity.Hospital;

import java.util.List;
import java.util.Optional;

public interface HospitalRepository {

    Hospital save(Hospital hospital);

    List<Hospital> findAll();

    Optional<Hospital> findById(String id);

    Optional<Hospital> findByName(String name);

}
