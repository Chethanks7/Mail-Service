package com.MailService.Mail_Service.controllers;

import com.MailService.Mail_Service.EmailRepo;
import com.MailService.Mail_Service.model.EmailModel;
import com.MailService.Mail_Service.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email-api")
public class EmailController {

    private final MailService mailService;

    @Autowired
    public EmailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/send-email")
    public String sendEmail(
            @RequestBody EmailModel emailModel
    ) {
        return mailService.sendSimpleMail(emailModel);
    }
}
