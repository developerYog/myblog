package com.myblogrestapi.repository;

import com.myblogrestapi.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments, Long> {
}
