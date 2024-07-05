package com.example.day13.likes.model.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LikeCreateOrDeleteRes {
    Long member_idx;
    Long post_idx;
    String result;
}
