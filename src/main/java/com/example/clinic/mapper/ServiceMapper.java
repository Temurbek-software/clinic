package com.example.clinic.mapper;

import com.example.clinic.entity.Attachment;
import com.example.clinic.entity.Patients;
import com.example.clinic.entity.Users;
import com.example.clinic.payload.AttachmentDTO;
import com.example.clinic.payload.PatientDTO;
import com.example.clinic.payload.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ServiceMapper
{
    @Mapping(target = "attachmentSet",ignore = true)
    @Mapping(target = "address",ignore = true)
    @Mapping(target = "disease",ignore = true)
    @Mapping(target = "recommendation",ignore = true)
    @Mapping(target = "treatment",ignore = true)
    @Mapping(target = "procedure",ignore = true)
    @Mapping(target = "comments",ignore = true)
    PatientDTO mapToPatientsDTO(Patients patients);
    @Mapping(target = "patientsAttachments", ignore = true)
    AttachmentDTO mapToAttachmentDTO(Attachment attachment);
    @Mapping(target = "patientsSet",ignore = true)
    UserDTO mapToUserDTO(Users users);
    @Mapping(target = "users",ignore = true)
//    @Mapping(target = "attachmentPatient",ignore = true)
    Patients mapToPatient(PatientDTO patientDTO);
}
