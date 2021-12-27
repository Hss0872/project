package com.best.team.community.dao;

import com.best.team.community.bean.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {

    public abstract boolean join(Member member);
}
