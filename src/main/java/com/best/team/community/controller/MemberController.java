package com.best.team.community.controller;

import com.best.team.community.bean.Member;
import com.best.team.community.service.MemberMM;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class MemberController {

    private final MemberMM mm;

    @Autowired
    public MemberController(MemberMM mm) {
        this.mm = mm;
    }

    @RequestMapping("/")
    public String test() {
        return "home";
    }

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String joinfrm() {
        log.info("회원가입 화면 이동");
        return "joinFrm";
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String join(Member member, Model model) {
        log.info("회원가입");
        mm.join(member, model);
        return "redirect:/";
    }
}