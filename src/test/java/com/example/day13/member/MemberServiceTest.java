package com.example.day13.member;

import com.example.day13.member.model.Member;
import com.example.day13.member.model.dto.request.MemberLoginReq;
import com.example.day13.member.model.dto.request.MemberSignupReq;
import com.example.day13.member.model.dto.response.MemberSignupRes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {
    @InjectMocks
    private MemberService memberService;
    @Mock
    private MemberRepository memberRepository;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    void memberService_signup_success(){
        //given
        MemberSignupReq memberSignupReq = MemberSignupReq.builder()
                .email("test01@gmail.com")
                .password("qwer1234")
                .build();
        Member member = Member.builder()
                .idx(1L)
                .email("test01@gmail.com")
                .password("qwer1234")
                .role("ROLE_USER")
                .build();
        given(memberRepository.save(any(Member.class))).willReturn(member);
        //when
        MemberSignupRes result = memberService.signup(memberSignupReq);
        //then
        assertNotNull(result);
        assertEquals(1L, result.getIdx());
        assertEquals("test01@gmail.com",result.getEmail());
    }
}