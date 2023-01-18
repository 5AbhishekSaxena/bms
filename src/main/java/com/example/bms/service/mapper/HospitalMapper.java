package com.example.bms.service.mapper;

import com.example.bms.entity.Hospital;
import com.example.bms.service.dto.HospitalDTO;
import org.springframework.stereotype.Service;

@Service
public class HospitalMapper {

    public HospitalDTO mapToDto(Hospital hospital) {
        return new HospitalDTO(
                hospital.getId(),
                hospital.getName(),
                hospital.getAddress(),
                hospital.getContact(),
                hospital.getNumberOfRooms(),
                hospital.getLogo()
        );
    }

    public Hospital mapToEntity(HospitalDTO hospitalDTO) {
        return new Hospital(
                hospitalDTO.getId(),
                hospitalDTO.getName(),
                hospitalDTO.getAddress(),
                hospitalDTO.getContact(),
                hospitalDTO.getNumberOfRooms(),
                hospitalDTO.getLogo()
        );
    }

}
