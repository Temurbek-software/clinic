package com.example.clinic.entity;

import com.example.clinic.entity.template.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "attachment")
public class Attachment extends BaseEntity {

    @Column(name = "imageName")
    private String imageName;

    @Column(name = "comments")
    private String commented;

    @Column(name = "typeOfImage")
    private String typeOfImage;

    @Lob
    @Column(name = "content")
    private byte[] contentImage;

    @ManyToOne(cascade = {
            CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @JsonIgnore
    private Patients patientsAttachments;

}
