package com.maryafolabi.facebookclone.service.serviceimplementation;


import com.maryafolabi.facebookclone.model.Post;
import com.maryafolabi.facebookclone.model.User;
import com.maryafolabi.facebookclone.repository.PostRepository;
import com.maryafolabi.facebookclone.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImplementation  implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public Iterable<Post> getAllPost() {
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "postID"));
    }

    @Override
    public void addPost(String body, User user) {
        Post post = new Post();
        post.setBody(body);
        post.setUser(user);
        postRepository.save(post);
    }

    @Override
    public Post getPostById(Long postID) {
        Optional<Post> post = postRepository.findById(postID);
        return post.get();
    }

    public void updatePost(Post editedPost) {
        Optional<Post> post = postRepository.findById(editedPost.getPostID());
        post.get().setBody(editedPost.getBody());
        postRepository.save(post.get());
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
