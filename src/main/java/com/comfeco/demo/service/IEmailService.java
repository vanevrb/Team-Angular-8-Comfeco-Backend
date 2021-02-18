package com.comfeco.demo.service;

import org.springframework.mail.SimpleMailMessage;

public interface IEmailService {

    void sendEmail(SimpleMailMessage email);
}
