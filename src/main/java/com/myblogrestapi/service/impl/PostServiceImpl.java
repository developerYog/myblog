package com.myblogrestapi.service.impl;

import com.myblogrestapi.entity.Post;
import com.myblogrestapi.exception.ResourceNotFoundException;
import com.myblogrestapi.payload.PostDto;
import com.myblogrestapi.repository.PostRepository;
import com.myblogrestapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postrepo;
    @Override
    public PostDto createPost(PostDto postDto) {
        //map dto to entity
        Post post = mapToEntity(postDto);
        Post newpost = postrepo.save(post);
        // convert entity to dto and return
        return mapToDto(newpost);
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postrepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post","Id",id)
        );
        return mapToDto(post);
    }

    @Override
    public PostDto updatePost(long id, PostDto postDto) {
        Post post = postrepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Post", "id", id));
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        post.setTitle(postDto.getTitle());
        Post savedPost = postrepo.save(post);
        return mapToDto(savedPost);
    }

    @Override
    public List<PostDto> getAllPost(int pageNo, int noOfPosts, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,noOfPosts,sort);
        Page<Post> postPage = postrepo.findAll(pageable);
        List<Post> posts= postPage.getContent();
        List<PostDto> newdto = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        return newdto;
    }


    private PostDto mapToDto(Post post){
        PostDto postDto= new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }

    private Post mapToEntity(PostDto postDto){
        Post post= new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }
}
