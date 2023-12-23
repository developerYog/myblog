package com.myblogrestapi.controller;

import com.myblogrestapi.payload.CommentDto;
import com.myblogrestapi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
@PostMapping("/{id}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(name="id") long id, @RequestBody CommentDto commentDto){
        CommentDto comment = commentService.createComment(id, commentDto);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }
}
