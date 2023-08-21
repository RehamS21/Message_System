package com.example.chatsystem.Service;

import com.example.chatsystem.Api.ApiException;
import com.example.chatsystem.Model.Doctor;
import com.example.chatsystem.Repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;


    public List<Doctor> getAllDoctor(){
        return doctorRepository.findAll();
    }

    public void addDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }

    public void updateDoctor(Integer id, Doctor doctor){
        Doctor oldDoctor = doctorRepository.findDoctorById(id);

        if (oldDoctor ==null)
            throw new ApiException("Sorry the doctor not found");

        oldDoctor.setName(doctor.getName());

        doctorRepository.save(oldDoctor);
    }

    public void deleteDoctor(Integer id){
        Doctor deleteDoctor = doctorRepository.findDoctorById(id);

        if (deleteDoctor == null)
            throw new ApiException("Sorry the doctor not found");

        doctorRepository.delete(deleteDoctor);
    }
}
