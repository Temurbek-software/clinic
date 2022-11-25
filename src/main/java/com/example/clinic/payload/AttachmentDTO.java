package com.example.clinic.payload;

import com.example.clinic.entity.Patients;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttachmentDTO {
    private Long id;
    private String contentImage;
    private String commented;
    private PatientDTO patientsAttachments;
}
