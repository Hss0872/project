package com.best.team.community.service;

import com.best.team.community.bean.Member;
import com.best.team.community.dao.MemberDao;
import com.best.team.community.userClass.Tempkey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Slf4j
@Service
public class MemberMM {

    private MemberDao memberDao;
    private MailService mailService;

    @Autowired
    public MemberMM(MemberDao memberDao, MailService mailService) {
        this.memberDao = memberDao;
        this.mailService = mailService;
    }

    public void join(Member member, Model model) {
        // 아이디 비밀번호 중복 확인 후 authkey 입력
        Tempkey tempkey = new Tempkey();
        String authkey = tempkey.getKey(20, false);
        log.info("authkey = {}", authkey);
        member.setAuthkey(authkey);
        
        if (memberDao.join(member)) {
            log.info("회원가입 성공");
        } else {
            model.addAttribute("msg", "로그인 실패");
            return;
        }

        String subject = "회원가입 서비스 이메일 인증 입니다.";
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>회원 가입 메일인증 입니다</h1>")
                .append("<a href='http://localhost:8090/emailconfirm?m_email=")
                .append(member.getM_email()).append("&authkey=").append(authkey)
                .append("'>클릭하세요</a>");
        System.out.println(sb.toString());
        mailService.send(subject, sb.toString(), "hssproject0872@gmail.com", member.getM_email(), null);
    }
}