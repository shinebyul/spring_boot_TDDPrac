package com.example.day13.post;

import com.example.day13.member.model.CustomUserDetails;
import com.example.day13.member.model.Member;
import com.example.day13.post.model.dto.request.PostCreateReq;
import com.example.day13.post.model.dto.response.PostCreateRes;
import com.example.day13.post.model.dto.response.PostListRes;
import com.example.day13.post.model.dto.response.PostReadRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<PostCreateRes> create(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                                @RequestBody PostCreateReq request){
        Member member = customUserDetails.getMember();
        PostCreateRes postCreateRes = postService.create(request, member);
        return ResponseEntity.ok(postCreateRes);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/read")
    public ResponseEntity<PostReadRes> read(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                            Long idx){
        Member member = customUserDetails.getMember();
        PostReadRes response = postService.read(idx, member);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity<PostListRes> read(@AuthenticationPrincipal CustomUserDetails customUserDetails){
        Member member = customUserDetails.getMember();
        PostListRes response = postService.list(member);
        return ResponseEntity.ok(response);
    }
}
