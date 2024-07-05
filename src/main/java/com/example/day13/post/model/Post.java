package com.example.day13.post.model;

import com.example.day13.likes.model.MemberLikePost;
import com.example.day13.member.model.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String contents;
    @ManyToOne
    @JoinColumn(name = "member_idx")
    private Member member;
    @OneToMany(mappedBy = "post")
    private List<MemberLikePost> memberLikePosts = new ArrayList<>();
}
