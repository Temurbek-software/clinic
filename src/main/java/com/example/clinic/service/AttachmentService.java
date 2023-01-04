package com.example.clinic.service;

import com.example.clinic.entity.Attachment;
import com.example.clinic.repository.AttachmentRepository;
import com.example.clinic.utils.ImageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

/**
 * @apiNote AttachmentService does uploadImage and download image in terms of image types
 * */
@Service
@RequiredArgsConstructor
public class AttachmentService
{
    private final AttachmentRepository attachmentRepository;

    public Attachment uploadImage(MultipartFile file) throws IOException {
        Attachment pImage = new Attachment();
        pImage.setImageName(file.getOriginalFilename());
        pImage.setTypeOfImage(file.getContentType());
        pImage.setContentImage(ImageUtil.compressImage(file.getBytes()));
        return attachmentRepository.save(pImage);
    }
    public byte[] downloadImage(String fileName) {
        Optional<Attachment> imageData = attachmentRepository.findByImageName(fileName);
        return ImageUtil.decompressImage(imageData.get().getContentImage());
    }

}
