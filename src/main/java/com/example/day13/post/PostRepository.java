package com.example.day13.post;

import com.example.day13.member.model.Member;
import com.example.day13.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByIdxAndMember(Long idx, Member member);
    List<Post> findAllByMember(Member member);
}
