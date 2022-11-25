package com.example.clinic.entity;

import com.example.clinic.entity.template.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patients")
public class Patients extends BaseEntity {

    @Column(name = "userName")
    private String userName;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "birthDate")
    private Date birthDate;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "disease")
    private String disease;

    @Column(name = "recommendation")
    private String recommendation;

    @Column(name = "treatment")
    private String treatment;

    @Column(name = "procedure")
    private String procedure;

    @Column(name = "comments")
    private String comments;
    @ManyToOne(cascade = {
            CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users users;

    @OneToMany(mappedBy = "patientsAttachments",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Attachment> attachmentPatient = new HashSet<>();

}
