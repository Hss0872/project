package com.best.team.community.dao;

import com.best.team.community.bean.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailDao {

    public boolean confirmEmail(Member member);

    void updateAuthstatus(Member member);
}
