package com.app.book.api.controller;

import com.app.book.api.common.code.ErrorCode;
import com.app.book.api.common.code.SuccessCode;
import com.app.book.api.common.exception.DataNotFoundException;
import com.app.book.api.common.response.ApiSuccess;
import com.app.book.api.domain.dto.Member;
import com.app.book.api.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "api/member", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class MemberController {

    private final MemberService memberService;

    private PasswordEncoder passwordEncoder;

    /**
     * Member 조회
     * @param dto
     * @return
     */
    @PostMapping({"", "/"})
    public ApiSuccess<Member> getMember(@RequestBody Member dto) {

        Member member = new Member();
        member.setMemId(dto.getMemId());

        int saveCnt = memberService.findByMemberCnt(member);
        if (saveCnt < 1) {
            throw new DataNotFoundException(ErrorCode.NOT_FOUND.getCode(), "회원으로 등록되어 있지 않습니다.");
        }

        Member data = memberService.findByMember(member);
        if (!passwordEncoder.matches(dto.getMemPwd(), passwordEncoder.encode(data.getMemPwd()))) {
            throw new DataNotFoundException(ErrorCode.NOT_FOUND.getCode(), "회원으로 등록되어 있지 않습니다.");
        }


        ApiSuccess result = new ApiSuccess(SuccessCode.SELECT);
        result.setData(data);

        return result;
    }

    /**
     * Member 여부 확인
     * @param dto
     * @return
     */
    @PostMapping("/check")
    public ApiSuccess<?> getMemberCheck(@RequestBody Member dto) {

        Member member = new Member();
        member.setMemId(dto.getMemId());

        int saveCnt = memberService.findByMemberCnt(member);
        if (saveCnt < 1) {
            throw new DataNotFoundException(ErrorCode.NOT_FOUND.getCode(), "회원으로 등록되어 있지 않습니다.");
        }

        Member data = memberService.findByMember(member);
        if (!passwordEncoder.matches(dto.getMemPwd(), passwordEncoder.encode(data.getMemPwd()))) {
            throw new DataNotFoundException(ErrorCode.NOT_FOUND.getCode(), "회원으로 등록되어 있지 않습니다.");
        }

        return new ApiSuccess(SuccessCode.SELECT);
    }
}
