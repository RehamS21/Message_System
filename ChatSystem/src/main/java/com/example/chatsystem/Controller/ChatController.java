package com.example.chatsystem.Controller;


import com.example.chatsystem.Api.ApiResponse;
import com.example.chatsystem.DTO.MessageDTO;
import com.example.chatsystem.Service.ChatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chat")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;
    @GetMapping("/get")
    public ResponseEntity getAllMessages(){
        return ResponseEntity.status(200).body(chatService.getChat());
    }

    @PostMapping("/add/{patient_id}")
    public ResponseEntity addNewMessage(@PathVariable Integer patient_id ,@RequestBody @Valid MessageDTO messageDTO){
        chatService.addChat(patient_id,messageDTO);
        return ResponseEntity.status(200).body(new ApiResponse("New message added successfully"));
    }

    @PutMapping("/update/{patient_id}")

    public ResponseEntity updateMessage(@PathVariable Integer patient_id ,@RequestBody @Valid MessageDTO messageDTO){
        chatService.updateChatMessage(patient_id,messageDTO);

        return ResponseEntity.status(200).body(new ApiResponse("the message updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMessage(@PathVariable Integer id){
        chatService.deleteChat(id);

        return ResponseEntity.status(200).body(new ApiResponse("the message deleted successfully"));
    }
}
