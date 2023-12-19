package com.myblogrestapi.service;

import com.myblogrestapi.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostDto getPostById(long id);

    PostDto updatePost(long id, PostDto postDto);

    List<PostDto> getAllPost(int pageNo, int noOfPosts, String sortBy, String sortDir);
}
