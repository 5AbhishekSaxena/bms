package com.example.bms.web.rest;

import com.example.bms.service.BMSException;
import com.example.bms.service.HospitalService;
import com.example.bms.service.dto.HospitalDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * All the exceptions a re handles centrally in the {@link com.example.bms.web.rest.error.BMSRestAdvice}
 */
@RestController
@RequestMapping("hospitals")
public class HospitalResource {

    private final HospitalService hospitalService;

    public HospitalResource(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/")
    ResponseEntity<List<HospitalDTO>> findAllHospitals() throws BMSException {
        List<HospitalDTO> body = hospitalService.findAll();
        return ResponseEntity.ok(body);
    }

    @GetMapping("/{id}")
    ResponseEntity<HospitalDTO> findHospitalById(@PathVariable("id") String id) throws BMSException {
        HospitalDTO body = hospitalService.findById(id);
        return ResponseEntity.ok(body);
    }
}
