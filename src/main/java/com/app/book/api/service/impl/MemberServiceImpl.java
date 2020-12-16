package com.app.book.api.service.impl;

import com.app.book.api.domain.dao.MemberDao;
import com.app.book.api.domain.dto.Member;
import com.app.book.api.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDao memberDao;

    @Override
    public int findByMemberCnt(Member dto) {
        return memberDao.selectMemberCnt(dto);
    }

    @Override
    public Member findByMember(Member dto) {
        return memberDao.selectMember(dto);
    }
}
