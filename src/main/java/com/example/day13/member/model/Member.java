package com.example.day13.member.model;

import com.example.day13.likes.model.MemberLikePost;
import com.example.day13.post.model.Post;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String email;
    private String password;
    private String role;
    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<MemberLikePost> memberLikePosts = new ArrayList<>();

}
