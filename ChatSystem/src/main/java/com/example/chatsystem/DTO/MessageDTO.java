package com.example.chatsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageDTO {
    private Integer doctor_id;
    private String message;
    private Integer patient_id;

}
