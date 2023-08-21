package com.example.chatsystem.Service;

import com.example.chatsystem.Api.ApiException;
import com.example.chatsystem.Model.Doctor;
import com.example.chatsystem.Model.Patient;
import com.example.chatsystem.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public List<Patient> getAllPatient(){
        return patientRepository.findAll();
    }

    public void addPatient(Patient patient){
        patientRepository.save(patient);
    }

    public void updatePatient(Integer id, Patient patient){
        Patient oldPatient = patientRepository.findPatientById(id);

        if (oldPatient ==null)
            throw new ApiException("Sorry the patient not found");

        oldPatient.setName(patient.getName());

        patientRepository.save(oldPatient);
    }

    public void deletePatient(Integer id){
        Patient deletePatient = patientRepository.findPatientById(id);

        if (deletePatient == null)
            throw new ApiException("Sorry the patient not found");

        patientRepository.delete(deletePatient);
    }
}
