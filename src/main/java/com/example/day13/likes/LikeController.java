package com.example.day13.likes;

import com.example.day13.likes.model.dto.response.LikeCreateOrDeleteRes;
import com.example.day13.member.model.CustomUserDetails;
import com.example.day13.member.model.Member;
import com.example.day13.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @RequestMapping("/create")
    public ResponseEntity<LikeCreateOrDeleteRes> createOrDelete(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                                                Long idx){
        Member member = customUserDetails.getMember();
        LikeCreateOrDeleteRes response = likeService.createOrDelete(idx, member);
        return ResponseEntity.ok(response);

    }
}
