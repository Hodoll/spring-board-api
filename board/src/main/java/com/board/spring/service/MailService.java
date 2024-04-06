package com.board.spring.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MailService implements ApplicationRunner{
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        MimeMessage m = mailSender.createMimeMessage();
        MimeMessageHelper h = new MimeMessageHelper(m,"UTF-8");
        //h.setFrom(from ("ghwls5490@naver.com"));
        h.setFrom("ghwls5490@naver.com");
        h.setTo("ghwls5490@naver.com");
        h.setSubject("상과장님 확인용 테스트메일");
        h.setText("과장님 확인용 테스트메일");
        mailSender.send(m);
    }


}
