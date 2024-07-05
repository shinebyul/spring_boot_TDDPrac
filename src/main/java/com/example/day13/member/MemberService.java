package com.example.day13.member;

import com.example.day13.member.model.dto.request.MemberSignupReq;
import com.example.day13.member.model.dto.response.MemberSignupRes;
import com.example.day13.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public MemberSignupRes signup(MemberSignupReq request){
        Member member = Member.builder()
                .email(request.getEmail())
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .role("ROLE_USER")
                .build();

        Member saved = memberRepository.save(member);

        MemberSignupRes memberSignupRes = MemberSignupRes.builder()
                .idx(saved.getIdx())
                .email(saved.getEmail())
                .build();

        return memberSignupRes;
    }
}
