package com.example.clinic.repository;

import com.example.clinic.entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientsRepository extends JpaRepository<Patients,Long>
{
    @Query(value = "select * from patients s where s.is_deleted=:deleted",nativeQuery = true)
    List<Patients> getAllByPatientIfNotDeleted(boolean deleted);
}
