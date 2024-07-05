package com.example.day13.likes;

import com.example.day13.likes.model.MemberLikePost;
import com.example.day13.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<MemberLikePost, Long> {
    Optional<MemberLikePost> findByPostIdxAndMember(Long postIdx, Member Member);
}
