package com.app.book.api.domain.dao;

import com.app.book.api.domain.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {

    int selectMemberCnt(Member dto);

    Member selectMember(Member dto);
}
