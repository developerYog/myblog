package com.myblogrestapi.controller;

import com.myblogrestapi.entity.Post;
import com.myblogrestapi.payload.PostDto;
import com.myblogrestapi.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService){
        this.postService=postService;
    }
    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto){
        PostDto newdto = postService.createPost(postDto);
        return new ResponseEntity<>(newdto, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable long id){
        PostDto postDto = postService.getPostById(id);
        return new ResponseEntity<>(postDto,HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity <List<PostDto>> getAllPost(
            @RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo,
            @RequestParam (name = "noOfPosts", required = false,defaultValue = "5") int noOfPosts,
            @RequestParam (name="sortBy", required = false, defaultValue="id") String sortBy,
            @RequestParam (name="sortDir", required = false, defaultValue="Asc") String sortDir
    ){
        List<PostDto> alldtos=postService.getAllPost(pageNo,noOfPosts,sortBy,sortDir);
        return new ResponseEntity<>(alldtos,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable long id, @Valid @RequestBody PostDto postDto){
        PostDto dto = postService.updatePost(id,postDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
