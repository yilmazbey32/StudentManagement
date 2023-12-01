package com.project.contactMessage.controller;

import com.project.contactMessage.entity.ContactMessage;
import com.project.contactMessage.service.ContactMessageService;
import com.project.payload.response.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contactMessage") //http://localhost:8080/contactMessages
@RequiredArgsConstructor// injection yapmak için
public class ContactMessageController {
    private final ContactMessageService contactMessageService;

    @PostMapping("/save") //http://localhost:8080/contactMessages/save + post+json
    public ResponseMessage<ContactMessageDTO>
}
