package com.best.team.community.bean;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Alias("Member")
@Getter
@Setter
public class Member {

    private String m_id;
    private String m_pwd;
    private int m_point;
    private String g_name;

    private String m_name;
    private String m_birth;
    private String m_addr;
    private String m_email;
    private String authkey;     //인증키
    private int authstatus;
}