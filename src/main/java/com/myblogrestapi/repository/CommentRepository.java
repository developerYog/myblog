package com.myblogrestapi.repository;

import com.myblogrestapi.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comments, Long> {
    List<Comments> findCommentsByPostId(long postid);
}
