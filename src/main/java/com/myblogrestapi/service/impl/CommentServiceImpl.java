package com.myblogrestapi.service.impl;

import com.myblogrestapi.entity.Comments;
import com.myblogrestapi.entity.Post;
import com.myblogrestapi.exception.ResourceNotFoundException;
import com.myblogrestapi.payload.CommentDto;
import com.myblogrestapi.payload.PostDto;
import com.myblogrestapi.repository.CommentRepository;
import com.myblogrestapi.repository.PostRepository;
import com.myblogrestapi.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentService {
    private ModelMapper mapper;
    private CommentRepository commentRepo;
    private PostRepository postRepo;

    @Override
    public CommentDto createComment(long postid, CommentDto commentDto) {
        postRepo.findById(postid).orElseThrow(()->new ResourceNotFoundException("Post","id",postid));
        Comments comments = commentRepo.save(mapper.map(commentDto, Comments.class));
        return mapper.map(comments,CommentDto.class);
    }

   private CommentDto mapToDto(Comments comments){
        return mapper.map(comments, CommentDto.class);
   }

    private Comments mapToComment(CommentDto commentDto){
        return mapper.map(commentDto, Comments.class);
    }

}
