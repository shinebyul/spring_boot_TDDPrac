package com.example.day13.post.model.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class PostInList {
    private String contents;
    private Integer numberOfLikes;
    private List<String> likeMembers;
}
