package com.example.chatsystem.Service;

import com.example.chatsystem.Api.ApiException;
import com.example.chatsystem.DTO.MessageDTO;
import com.example.chatsystem.Model.Chat;
import com.example.chatsystem.Model.Doctor;
import com.example.chatsystem.Model.Patient;
import com.example.chatsystem.Repository.ChatRepository;
import com.example.chatsystem.Repository.DoctorRepository;
import com.example.chatsystem.Repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public List<Chat> getChat(){
        return chatRepository.findAll();
    }

    public void addChat(Integer patient_id,MessageDTO messageDTO){
        Doctor doctor = doctorRepository.findDoctorById(messageDTO.getDoctor_id());
        Patient patient = patientRepository.findPatientById(patient_id) ;
        if (doctor == null)
            throw new ApiException("No doctor");
        else if (patient == null) {
            throw new ApiException("Sorry , patient id is wrong");
        }



        Chat chat = new Chat(null, messageDTO.getMessage(), doctor,patient);
        chatRepository.save(chat);
    }

    public void updateChatMessage(Integer patient_id,MessageDTO messageDTO){
        Doctor doctor = doctorRepository.findDoctorById(messageDTO.getDoctor_id());
        Patient patient = patientRepository.findPatientById(patient_id) ;

        if (doctor == null)
            throw new ApiException("No doctor");
        else if (patient == null) {
            throw new ApiException("Sorry , patient id is wrong");
        }
        Chat chat = new Chat(messageDTO.getDoctor_id(), messageDTO.getMessage(), doctor,patient);

        chatRepository.save(chat);
    }

    public void deleteChat(Integer id){
        Chat chat  = chatRepository.findChatById(id);
        Doctor doctor = doctorRepository.findDoctorById(chat.getDoctor().getId());

        if (chat == null)
            throw new ApiException("Sorry message id is wrong");

        doctor.setChat(null);
        doctorRepository.save(doctor);
        chatRepository.delete(chat);
    }


}
