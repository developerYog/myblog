package com.myblogrestapi.service;

import com.myblogrestapi.entity.Comments;
import com.myblogrestapi.entity.Post;
import com.myblogrestapi.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(long postid, CommentDto commentDto);

}


