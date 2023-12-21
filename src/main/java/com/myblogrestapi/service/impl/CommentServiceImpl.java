package com.myblogrestapi.service.impl;

import com.myblogrestapi.entity.Comments;
import com.myblogrestapi.entity.Post;
import com.myblogrestapi.payload.CommentDto;
import com.myblogrestapi.payload.PostDto;
import com.myblogrestapi.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private ModelMapper mapper;

    @Override
    public CommentDto createComment(long postid, CommentDto commentDto) {
        return null;
    }

   private CommentDto mapToDto(Comments comments){
        return mapper.map(comments, CommentDto.class);
   }

    private Comments mapToComment(CommentDto commentDto){
        return mapper.map(commentDto, Comments.class);
    }

}
