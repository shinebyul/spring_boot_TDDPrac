package com.example.day13.post;

import com.example.day13.likes.model.MemberLikePost;
import com.example.day13.member.model.Member;
import com.example.day13.post.model.Post;
import com.example.day13.post.model.dto.request.PostCreateReq;
import com.example.day13.post.model.dto.response.PostCreateRes;
import com.example.day13.post.model.dto.response.PostInList;
import com.example.day13.post.model.dto.response.PostListRes;
import com.example.day13.post.model.dto.response.PostReadRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public PostCreateRes create(PostCreateReq request, Member member){
        Post post = Post.builder()
                .contents(request.getContents())
                .member(member)
                .build();

        Post saved = postRepository.save(post);

        PostCreateRes postCreateRes = PostCreateRes.builder()
                .idx(saved.getIdx())
                .contents(saved.getContents())
                .build();

        return postCreateRes;
    }

    public PostReadRes read(Long idx, Member member){
        Optional<Post> result = postRepository.findByIdxAndMember(idx, member);
        if(result.isPresent()){
            Post post = result.get();

            List<String> likeMembers = new ArrayList<>();
            List<MemberLikePost> memberLikePosts = post.getMemberLikePosts();

            for (MemberLikePost memberLikePost : memberLikePosts) {
                likeMembers.add(memberLikePost.getMember().getEmail());
            }

            PostReadRes postReadRes = PostReadRes.builder()
                    .email(post.getMember().getEmail())
                    .contents(post.getContents())
                    .likeMembers(likeMembers)
                    .numberOfLikes(likeMembers.size())
                    .build();

            return postReadRes;
        }
        return null;
    }

    public PostListRes list(Member member){
        List<Post> posts = postRepository.findAllByMember(member);
        List<PostInList> postInLists = new ArrayList<>();

        for (Post post : posts) {
            List<String> likeMembers = new ArrayList<>();
            List<MemberLikePost> memberLikePosts = post.getMemberLikePosts();

            for (MemberLikePost memberLikePost : memberLikePosts) {
                likeMembers.add(memberLikePost.getMember().getEmail());
            }

            PostInList postInList = PostInList.builder()
                    .contents(post.getContents())
                    .numberOfLikes(memberLikePosts.size())
                    .likeMembers(likeMembers)
                    .build();

            postInLists.add(postInList);
        }

        PostListRes postListRes = PostListRes.builder()
                .idx(member.getIdx())
                .email(member.getEmail())
                .posts(postInLists)
                .build();

        return postListRes;
    }
}
