package com.example.day13.post.model.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
public class PostListRes {
    Long idx;
    String email;
    List<PostInList> posts = new ArrayList<>();
}
