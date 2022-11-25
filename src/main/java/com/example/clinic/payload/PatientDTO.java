package com.example.clinic.payload;

import com.example.clinic.entity.Attachment;
import com.example.clinic.entity.Users;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientDTO {

    private Long id;
    private String userName;
    private String fullName;
    private Date birthDate;
    private String phoneNumber;
    private String address;
    private String disease;
    private String recommendation;
    private String treatment;
    private String procedure;
    private String comments;
    private UserDTO users;
    private Set<AttachmentDTO> attachmentSet;
}
