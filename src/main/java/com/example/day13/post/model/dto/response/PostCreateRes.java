package com.example.day13.post.model.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostCreateRes {
    private Long idx;
    private String contents;
}
