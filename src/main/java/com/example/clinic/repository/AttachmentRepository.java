package com.example.clinic.repository;

import com.example.clinic.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long>
{
    Optional<Attachment> findByImageName(String fileName);
}
