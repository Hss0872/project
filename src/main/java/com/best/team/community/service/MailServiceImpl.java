package com.best.team.community.service;
import com.best.team.community.bean.Member;
import com.best.team.community.dao.EmailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailServiceImpl implements MailService {

    private JavaMailSender javaMailSender;
    private EmailDao emailDao;

    @Autowired
    public MailServiceImpl(JavaMailSender javaMailSender, EmailDao emailDao) {
        this.javaMailSender = javaMailSender;
        this.emailDao = emailDao;
    }

    public boolean send(String subject, String text, String from, String to, String filePath) {
        // javax.mail.internet.MimeMessage
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            // org.springframework.mail.javamail.MimeMessageHelper
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setSubject(subject);
            helper.setText(text, true);
            helper.setFrom(from);
            helper.setTo(to);

            // 첨부 파일 처리
            if (filePath != null) {
                File file = new File(filePath);
                if (file.exists()) {
                    helper.addAttachment(file.getName(), new File(filePath));
                }
            }

            javaMailSender.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String confirmEmail(Member member) {
        if (emailDao.confirmEmail(member)) {
            emailDao.updateAuthstatus(member);
            return "이메일 인증이 완료되었습니다.";
        } else {
            return "경로가 잘못되었습니다";
        }
    }
}
