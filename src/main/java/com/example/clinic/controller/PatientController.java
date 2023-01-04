package com.example.clinic.controller;

import com.example.clinic.payload.ApiResult;
import com.example.clinic.payload.PatientDTO;
import com.example.clinic.service.AttachmentService;
import com.example.clinic.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.*;

/***
 * @author Temurbek
 * @apiNote This is Patient controller, where get one,
 * getAll, save, update and also print all cards
 *
 */

@RequestMapping("/api/patient")
@RestController
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    private final AttachmentService attachmentService;

    @GetMapping("/getAll")
    public ApiResult<List<PatientDTO>> showAllItems() {
        return patientService.getListOfPatientsWithDoctor();
    }

    //    Upload multiple images or one image into directly database
    @PostMapping("/upload")
    public void uploadImage(@RequestParam("patientPhoto") MultipartFile file) throws IOException {
        attachmentService.uploadImage(file);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable String fileName) {
        byte[] image = attachmentService.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK).contentType(valueOf("image/png")).body(image);
    }

    //    @RequestMapping(method = RequestMethod.GET,value = "/pdfreport",
//            produces = MediaType.APPLICATION_PDF_VALUE)
//    public ResponseEntity<InputStreamResource> citiesReport() {
//
//        List<Patients> patientsList=patients.findAll();
//        ByteArrayInputStream bis = GeneratePdfReport.citiesReport(patientsList);
//
//        var headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(new InputStreamResource(bis));
//    }
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
    public ApiResult<?> deleteItem(@PathVariable Long id) {
        return patientService.deleteItemsById(id);
    }
}
