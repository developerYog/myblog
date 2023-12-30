package com.myblogrestapi.service.impl;

import com.myblogrestapi.entity.Comments;
import com.myblogrestapi.entity.Post;
import com.myblogrestapi.exception.ResourceNotFoundException;
import com.myblogrestapi.payload.CommentDto;
import com.myblogrestapi.repository.CommentRepository;
import com.myblogrestapi.repository.PostRepository;
import com.myblogrestapi.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommentServiceImpl implements CommentService {
    private ModelMapper mapper;
    private CommentRepository commentRepo;
    private PostRepository postRepo;
    @Autowired
    public CommentServiceImpl(ModelMapper mapper, CommentRepository commentRepo, PostRepository postRepo) {
        this.mapper = mapper;
        this.commentRepo = commentRepo;
        this.postRepo = postRepo;
    }

    @Override
    public CommentDto createComment(long postid, CommentDto commentDto) {
        Comments comments= mapper.map(commentDto,Comments.class);

        //Check and Store if post with the given id is available or not
        Post post = postRepo.findById(postid).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postid));
        //if post found set post details in Comments entity to save comments to respective post
        comments.setPost(post);
        // Save comment
        Comments newComment = commentRepo.save(comments);
        return mapper.map(newComment,CommentDto.class);
    }

    @Override
    public List<CommentDto> getCommentByPost(long id) {
        List <Comments> comments= commentRepo.findCommentsByPostId(id);
        List<CommentDto> dtos = comments.stream().map(c -> mapToDto(c)).collect(Collectors.toList());
        return dtos;
    }

    private CommentDto mapToDto(Comments comments){
        return mapper.map(comments, CommentDto.class);
   }

    private Comments mapToComment(CommentDto commentDto){
        return mapper.map(commentDto, Comments.class);
    }

}
