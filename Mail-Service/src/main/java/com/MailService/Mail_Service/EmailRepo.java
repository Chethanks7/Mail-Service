package com.MailService.Mail_Service;

import com.MailService.Mail_Service.model.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmailRepo extends JpaRepository<EmailModel, Integer> {

    public EmailModel findByToMail(String email);
}
