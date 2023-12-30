package com.myblogrestapi.service;

import com.myblogrestapi.entity.Comments;
import com.myblogrestapi.entity.Post;
import com.myblogrestapi.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postid, CommentDto commentDto);

    List<CommentDto> getCommentByPost(long id);
}


