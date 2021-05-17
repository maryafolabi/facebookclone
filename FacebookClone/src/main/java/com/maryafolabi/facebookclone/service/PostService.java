package com.maryafolabi.facebookclone.service;


import com.maryafolabi.facebookclone.model.Post;
import com.maryafolabi.facebookclone.model.User;
import org.springframework.stereotype.Service;

@Service
public interface PostService  {


    Iterable<Post> getAllPost();
    void addPost(String body, User user);
    Post getPostById(Long postID);
}
