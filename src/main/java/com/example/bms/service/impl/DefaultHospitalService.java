package com.example.bms.service.impl;

import com.example.bms.entity.Hospital;
import com.example.bms.repository.HospitalRepository;
import com.example.bms.service.BMSException;
import com.example.bms.service.HospitalService;
import com.example.bms.service.dto.HospitalDTO;
import com.example.bms.service.mapper.HospitalMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DefaultHospitalService implements HospitalService {

    private final HospitalMapper hospitalMapper;

    private final HospitalRepository hospitalRepository;

    public DefaultHospitalService(HospitalMapper hospitalMapper, HospitalRepository hospitalRepository) {
        this.hospitalMapper = hospitalMapper;
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public HospitalDTO save(HospitalDTO hospitalDTO) throws BMSException {
        if (hospitalDTO.getId() != null)
            throw new BMSException("Id must be null.");

        if (hospitalDTO.getName() == null)
            throw new BMSException("Name must be not be null.");

        // todo: Add validation for other fields and throw appropriate exception if needed.

        Hospital hospital = hospitalMapper.mapToEntity(hospitalDTO);
        hospital.setId(UUID.randomUUID().toString());
        Hospital newHospital = hospitalRepository.save(hospital);
        return hospitalMapper.mapToDto(newHospital);
    }

    @Override
    public List<HospitalDTO> findAll() throws BMSException {
        List<Hospital> hospitals = hospitalRepository.findAll();

        if (hospitals.isEmpty())
            throw new BMSException("Hospitals not found.");

        return hospitals.stream()
                .map(hospitalMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public HospitalDTO findById(String id) throws BMSException {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        Hospital hospital = optionalHospital.orElseThrow(
                () -> new BMSException(String.format("Hospital with id %d not found.", id))
        );
        return hospitalMapper.mapToDto(hospital);
    }

    @Override
    public HospitalDTO findByName(String name) throws BMSException {
        Optional<Hospital> optionalHospital = hospitalRepository.findByName(name);
        Hospital hospital = optionalHospital.orElseThrow(
                () -> new BMSException(String.format("Hospital with name %s not found.", name))
        );
        return hospitalMapper.mapToDto(hospital);
    }
}
