package com.board.spring.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.board.spring.util.DateUtil;
import com.board.spring.vo.BoardVO;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public  class MailService {
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;
    
    @Async
    public void run(BoardVO boardVO) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,"UTF-8");
        
        try {
        	helper.setFrom(from);
        	helper.setTo(from);
        	helper.setSubject("[게시글 삭제]" + boardVO.getContentName() + "이(가) 삭제되었습니다.");        	
        	helper.setText(DateUtil.getCurrentDateTime() + "에 해당 게시글이 삭제되었습니다.");
			
		} catch (MessagingException e) {
			//TODO : Error logging
			log.debug(from);
		}

        mailSender.send(message);
    }
}
