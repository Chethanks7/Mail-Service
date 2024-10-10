package com.MailService.Mail_Service.services;

import com.MailService.Mail_Service.EmailRepo;
import com.MailService.Mail_Service.model.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final JavaMailSender mailSender;
    private final EmailRepo emailRepo;

    @Autowired
    public MailService(JavaMailSender mailSender, EmailRepo emailRepo) {
        this.mailSender = mailSender;
        this.emailRepo = emailRepo;
    }

    public String sendSimpleMail(EmailModel emailModel) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailModel.getToMail());
        message.setSubject(emailModel.getSubject());
        message.setText(emailModel.getText());
        mailSender.send(message);
        emailRepo.save(emailModel);
        return "Mail sent successfully";
    }
}
