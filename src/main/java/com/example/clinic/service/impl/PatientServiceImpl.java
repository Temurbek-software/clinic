package com.example.clinic.service.impl;

import com.example.clinic.entity.Patients;
import com.example.clinic.exception.RestException;
import com.example.clinic.mapper.ServiceMapper;
import com.example.clinic.payload.ApiResult;
import com.example.clinic.payload.PatientDTO;
import com.example.clinic.repository.PatientsRepository;
import com.example.clinic.service.MessageService;
import com.example.clinic.service.PatientService;
import com.example.clinic.utils.MessageConstants;
import com.example.clinic.utils.RestConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    /**
     * in Main page, Patients cards with little info attached docs name
     */
    @Override
    public ApiResult<List<PatientDTO>> getListOfPatientsWithDoctor() {
        List<PatientDTO> patientDTOList = patientsRepository.getAllByPatientIfNotDeleted(false)
                .stream()
                .map(serviceMapper::mapToPatientsDTO)
                .collect(Collectors.toList());
        return ApiResult.successResponse(patientDTOList);
    }

    @Override
    public ApiResult<List<PatientDTO>> getListOfPatients() {
        List<PatientDTO> patientDTOList = patientsRepository.getAllByPatientIfNotDeleted(false).stream()
                .map(this::mapToPatientDTO).collect(Collectors.toList());
        return ApiResult.successResponse(patientDTOList);
    }

    @Override
    public ApiResult<PatientDTO> getItemsById(Long id) {
        Patients patients = patientsRepository.findById(id).orElseThrow(
                () -> RestException.restThrow(MessageConstants.USER_NOT_FOUND,
                        RestConstants.NOT_FOUND, HttpStatus.NOT_FOUND)
        );
        PatientDTO patientDTO = mapToPatientDTO(patients);
        return ApiResult.successResponse(patientDTO);
    }
    @Override
    public ApiResult<?> insertNewPatient(PatientDTO patients) {
        Patients patients1 = serviceMapper.mapToPatient(patients);
        patientsRepository.save(patients1);
        return ApiResult.successResponse("Saved");
    }

    @Override
    public ApiResult<?> updatePatient(PatientDTO patients, Long id) {
        Patients patients1 = patientsRepository.findById(id).orElseThrow(
                () -> RestException.restThrow("Patient", "id", id,
                        MessageService.getMessage("PATIENT_NOT_FOUND"))
        );
        patients1.setPhoneNumber(patients.getPhoneNumber());
        patients1.setAddress(patients.getAddress());
        patients1.setDisease(patients.getDisease());
        patients1.setRecommendation(patients.getRecommendation());
        patients1.setBirthDate(patients.getBirthDate());
        patients1.setFullName(patients1.getFullName());
        patients1.setProcedure(patients.getProcedure());
        patients1.setPhoneNumber(patients1.getPhoneNumber());
        patients1.setTreatment(patients.getTreatment());
        patients1.setComments(patients.getComments());
        patientsRepository.save(patients1);
        return ApiResult.successResponse("Updated patient");
    }

    @Override
    public ApiResult<?> deleteItemsById(Long id) {
        Patients patients1 = patientsRepository.findById(id).orElseThrow(
                () -> RestException.restThrow("Patient", "id", id,
                        MessageService.getMessage("PATIENT_NOT_FOUND"))
        );
        patients1.setDeleted(true);
        patientsRepository.save(patients1);
        return ApiResult.successResponse("Deleted");
    }


}
