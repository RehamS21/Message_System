package com.example.chatsystem.Controller;

import com.example.chatsystem.Api.ApiResponse;
import com.example.chatsystem.Model.Doctor;
import com.example.chatsystem.Service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("/get")
    public ResponseEntity getAllDoctors(){
        return ResponseEntity.status(200).body(doctorService.getAllDoctor());
    }

    @PostMapping("/add")
    public ResponseEntity addNewDoctor(@RequestBody @Valid Doctor doctor){
        doctorService.addDoctor(doctor);
        return ResponseEntity.status(200).body(new ApiResponse("New doctor added successfully"));
    }

    @PutMapping("/update/{id}")

    public ResponseEntity updateDoctors(@PathVariable Integer id,@RequestBody @Valid Doctor doctor){
        doctorService.updateDoctor(id,doctor);

        return ResponseEntity.status(200).body(new ApiResponse("the doctor updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDoctors(@PathVariable Integer id){
        doctorService.deleteDoctor(id);

        return ResponseEntity.status(200).body(new ApiResponse("the doctor deleted successfully"));
    }
}
