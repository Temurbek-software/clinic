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
public class Attachment extends BaseEntity {
    @Column(name = "content")
    private String contentImage;
    @Column(name = "comments")
    private String commented;
    @ManyToOne(cascade = {
            CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @JsonIgnore
    private Patients patientsAttachments;

}
