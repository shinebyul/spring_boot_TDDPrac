package com.example.day13.member;

import com.example.day13.member.model.dto.request.MemberSignupReq;
import com.example.day13.member.model.dto.response.MemberSignupRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/member")
public class MemberController {
    private final MemberService memberService;
    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public ResponseEntity<MemberSignupRes> signup(@RequestBody MemberSignupReq request){
        MemberSignupRes reponse = memberService.signup(request);
        return ResponseEntity.ok(reponse);
    }
}
