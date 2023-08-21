package com.example.chatsystem.Controller;

import com.example.chatsystem.Api.ApiResponse;
import com.example.chatsystem.Model.Doctor;
import com.example.chatsystem.Model.Patient;
import com.example.chatsystem.Service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/get")
    public ResponseEntity getAllPatients(){
        return ResponseEntity.status(200).body(patientService.getAllPatient());
    }

    @PostMapping("/add")
    public ResponseEntity addNewPatient(@RequestBody @Valid Patient patient){
        patientService.addPatient(patient);
        return ResponseEntity.status(200).body(new ApiResponse("New patient added successfully"));
    }

    @PutMapping("/update/{id}")

    public ResponseEntity updatePatients(@PathVariable Integer id,@RequestBody @Valid Patient patient){
        patientService.updatePatient(id,patient);

        return ResponseEntity.status(200).body(new ApiResponse("the patient updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePatients(@PathVariable Integer id){
        patientService.deletePatient(id);

        return ResponseEntity.status(200).body(new ApiResponse("the patient deleted successfully"));
    }
}
