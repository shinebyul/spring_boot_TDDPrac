package com.example.day13.likes;

import com.example.day13.likes.model.MemberLikePost;
import com.example.day13.likes.model.dto.response.LikeCreateOrDeleteRes;
import com.example.day13.member.MemberRepository;
import com.example.day13.member.model.Member;
import com.example.day13.post.PostRepository;
import com.example.day13.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;
    private final PostRepository postRepository;

    public LikeCreateOrDeleteRes createOrDelete(Long postIdx, Member member){
        Optional<MemberLikePost> liked = likeRepository
                .findByPostIdxAndMember(postIdx, member);

        if(liked.isPresent()){
            likeRepository.delete(liked.get());

            return LikeCreateOrDeleteRes.builder()
                    .member_idx(member.getIdx())
                    .post_idx(postIdx)
                    .result("삭제 성공")
                    .build();

        }else{
            Post post = postRepository.findById(postIdx).get();

             MemberLikePost memberLikePost = MemberLikePost.builder()
                     .member(member)
                     .post(post)
                     .build();

             likeRepository.save(memberLikePost);

            return LikeCreateOrDeleteRes.builder()
                    .member_idx(member.getIdx())
                    .post_idx(postIdx)
                    .result("저장 성공")
                    .build();
        }
    }
}
