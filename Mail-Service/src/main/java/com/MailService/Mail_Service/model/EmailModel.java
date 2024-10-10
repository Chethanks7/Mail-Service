package com.MailService.Mail_Service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Data
public class EmailModel {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String toMail;

    @Value("${spring.mail.username}")
    private String fromMail;
    private String subject;
    private String text ;

}
