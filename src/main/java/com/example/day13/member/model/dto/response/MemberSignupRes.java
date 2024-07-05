package com.example.day13.member.model.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberSignupRes {
    private Long idx;
    private String email;
}
