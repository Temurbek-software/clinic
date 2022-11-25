package com.example.clinic.service.impl;

import com.example.clinic.entity.Patients;
import com.example.clinic.mapper.ServiceMapper;
import com.example.clinic.payload.ApiResult;
import com.example.clinic.payload.PatientDTO;
import com.example.clinic.repository.PatientsRepository;
import com.example.clinic.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PatientServiceImpl implements PatientService {

    private final PatientsRepository patientsRepository;
    private final ServiceMapper serviceMapper;

    @Override
    public PatientDTO mapToPatientDTO(Patients patients) {
        if (patients == null) {
            return null;
        }
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patients.getId());
        patientDTO.setUserName(patients.getUserName());
        patientDTO.setFullName(patients.getFullName());
        patientDTO.setBirthDate(patients.getBirthDate());
        patientDTO.setPhoneNumber(patients.getPhoneNumber());
        patientDTO.setAddress(patients.getAddress());
        patientDTO.setDisease(patients.getDisease());
        patientDTO.setRecommendation(patients.getRecommendation());
        patientDTO.setTreatment(patients.getTreatment());
        patientDTO.setProcedure(patients.getProcedure());
        patientDTO.setUsers(serviceMapper.mapToUserDTO(patients.getUsers()));
        patientDTO.setAttachmentSet(patients.getAttachmentPatient()
                .stream()
                .map(serviceMapper::mapToAttachmentDTO)
                .collect(Collectors.toSet()));
        return patientDTO;
    }

    @Override
    public ApiResult<List<PatientDTO>> getListOfPatientsWithDoctor() {
        return null;
    }

    @Override
    public ApiResult<List<PatientDTO>> getListOfPatients() {
        List<PatientDTO> patientDTOList = patientsRepository.getAllByPatientIfNotDeleted(false).stream()
                .map(this::mapToPatientDTO).collect(Collectors.toList());
        return ApiResult.successResponse(patientDTOList);
    }

    @Override
    public ApiResult<PatientDTO> getItemsById(Long id) {
        return null;
    }

    @Override
    public ApiResult<?> insertNewPatient(PatientDTO patients) {
        return null;
    }

    @Override
    public ApiResult<?> updatePatient(PatientDTO patients, Long id) {
        return null;
    }

    @Override
    public ApiResult<?> deleteItemsById(Long id) {
        return null;
    }


}
