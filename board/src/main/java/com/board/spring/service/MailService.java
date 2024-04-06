package com.board.spring.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.board.spring.vo.MailVO;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public  class MailService implements ApplicationRunner{
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;
    
    public void run(ApplicationArguments args) throws MessagingException {
        MimeMessage m = mailSender.createMimeMessage();
        MimeMessageHelper h = new MimeMessageHelper(m,"UTF-8");
        h.setFrom(from);
        h.setTo(from);
        h.setSubject("[게시글 삭제]" + MailVO.contentName + "이(가) 삭제되었습니다.");        	
    	h.setText(MailVO.contentDelDt + "에 해당 게시글이 삭제되었습니다.");

        mailSender.send(m);
    }
}
