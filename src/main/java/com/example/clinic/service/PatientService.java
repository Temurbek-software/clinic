package com.example.clinic.service;

import com.example.clinic.entity.Patients;
import com.example.clinic.payload.ApiResult;
import com.example.clinic.payload.PatientDTO;

import java.util.List;

public interface PatientService {
    ApiResult<List<PatientDTO>> getListOfPatients();
    ApiResult<List<PatientDTO>> getListOfPatientsWithDoctor();
    ApiResult<PatientDTO> getItemsById(Long id);
    ApiResult<?> insertNewPatient(PatientDTO patients);
    ApiResult<?> updatePatient(PatientDTO patients,Long id);
    ApiResult<?> deleteItemsById(Long id);

    PatientDTO mapToPatientDTO(Patients patients);
}
