package com.example.clinic.controller;

import com.example.clinic.payload.ApiResult;
import com.example.clinic.payload.PatientDTO;
import com.example.clinic.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/patient")
@RestController
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/getAll")
    public ApiResult<List<PatientDTO>> showAllItems() {
        return patientService.getListOfPatients();
    }

    @GetMapping("/get/{id}")
    public ApiResult<PatientDTO> getOneItems(@PathVariable Long id) {
        return patientService.getItemsById(id);
    }

    @PostMapping("/save")
    public ApiResult<?> insertItem(@RequestBody PatientDTO patientDTO) {
        return patientService.insertNewPatient(patientDTO);
    }

    @PutMapping("/update/{id}")
    public ApiResult<?> updateItem(@RequestBody PatientDTO patientDTO, @PathVariable Long id) {
        return patientService.updatePatient(patientDTO, id);
    }
    @DeleteMapping("/delete/{id}")
    public ApiResult<?> deleteItem(@PathVariable Long id)
    {
        return patientService.deleteItemsById(id);
    }
}
