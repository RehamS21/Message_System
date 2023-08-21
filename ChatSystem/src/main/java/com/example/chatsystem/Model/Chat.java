package com.example.chatsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Chat {
    @Id
    private Integer id;
    @NotEmpty(message = "Should not empty message")
    private String message;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name ="patient_id",referencedColumnName = "id")
    @JsonIgnore
    private Patient patient;

}
