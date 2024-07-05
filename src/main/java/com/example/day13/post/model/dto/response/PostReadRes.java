package com.example.day13.post.model.dto.response;

import com.example.day13.likes.model.MemberLikePost;
import com.example.day13.member.model.Member;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
public class PostReadRes {
    private String contents;
    private String email;
    private Integer numberOfLikes;
    private List<String> likeMembers;
}
