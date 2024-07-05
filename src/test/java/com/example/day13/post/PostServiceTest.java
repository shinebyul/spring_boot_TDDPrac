package com.example.day13.post;

import com.example.day13.likes.model.MemberLikePost;
import com.example.day13.member.MemberService;
import com.example.day13.member.model.Member;
import com.example.day13.post.model.Post;
import com.example.day13.post.model.dto.request.PostCreateReq;
import com.example.day13.post.model.dto.response.PostCreateRes;
import com.example.day13.post.model.dto.response.PostReadRes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {
    @InjectMocks
    private PostService postService;
    @Mock
    private PostRepository postRepository;

    @Test
    void postService_create_success(){
        //given
        PostCreateReq postCreateReq = PostCreateReq.builder()
                .contents("goooooood!!!")
                .build();
        Member member = Member.builder()
                .idx(1L)
                .build();
        Post post = Post.builder()
                .idx(1L)
                .contents("goooooood!!!")
                .member(member)
                .build();
        given(postRepository.save(any(Post.class))).willReturn(post);
        //when
        PostCreateRes result = postService.create(postCreateReq, member);
        //then
        assertNotNull(result);
        assertEquals(1L, result.getIdx());
        assertEquals("goooooood!!!",result.getContents());
    }

    @Test
    void postService_read_success() {
        //given
        List<MemberLikePost> memberLikePosts = new ArrayList<>();
        Member member = Member.builder()
                .idx(1L)
                .email("test01@gmail.com")
                .build();
        Post post = Post.builder()
                .idx(1L)
                .contents("goooooood!!!")
                .member(member)
                .memberLikePosts(memberLikePosts)
                .build();

        given(postRepository.findByIdxAndMember(any(Long.class), any(Member.class)))
                .willReturn(Optional.ofNullable(post));
        //when
        PostReadRes result = postService.read(1L, member);
        //then
        assertNotNull(result);
        assertEquals("goooooood!!!", result.getContents());
        assertEquals("test01@gmail.com",result.getEmail());
    }

    @Test
    void postService_list_success(){
        //given

        //when
        //then
    }
}