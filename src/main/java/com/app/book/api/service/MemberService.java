package com.app.book.api.service;

import com.app.book.api.domain.dto.Member;

public interface MemberService {

    int findByMemberCnt(Member dto);

    Member findByMember(Member dto);
}
