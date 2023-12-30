package com.myblogrestapi.controller;

import com.myblogrestapi.payload.CommentDto;
import com.myblogrestapi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
@PostMapping("/posts/{id}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(name="id") long id, @Valid @RequestBody CommentDto commentDto){
        CommentDto comment = commentService.createComment(id, commentDto);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CommentDto>> getCommentByPost(@RequestParam long id){
        List<CommentDto> comments = commentService.getCommentByPost(id);
        return new ResponseEntity<>(comments,HttpStatus.OK);
    }
}


