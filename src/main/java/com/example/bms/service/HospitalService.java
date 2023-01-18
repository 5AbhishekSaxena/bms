package com.example.bms.service;

import com.example.bms.service.dto.HospitalDTO;

import java.util.List;

public interface HospitalService {

    HospitalDTO save(HospitalDTO hospitalDTO) throws BMSException;

    List<HospitalDTO> findAll() throws BMSException;

    HospitalDTO findById(String id) throws BMSException;

    HospitalDTO findByName(String name) throws BMSException;
}
