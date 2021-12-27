package com.best.team.community.controller;

import com.best.team.community.bean.Member;
import com.best.team.community.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailController {

    private final MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @RequestMapping("/emailconfirm")
    public String emailConfirm(Member member, Model model) {
        String msg = mailService.confirmEmail(member);
        model.addAttribute("msg", msg);
        return "home";
    }
}
