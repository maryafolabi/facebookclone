package com.maryafolabi.facebookclone.service.serviceimplementation;


import com.maryafolabi.facebookclone.model.Comment;
import com.maryafolabi.facebookclone.model.Post;
import com.maryafolabi.facebookclone.repository.CommentRepository;
import com.maryafolabi.facebookclone.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CommentServiceImplementation {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    public Iterable<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    public void saveComment(Comment comment, Long postId) {

        Comment commentDB = commentRepository.save(comment);
        Optional<Post> post = postRepository.findById(postId);
        List<Comment> comments = post.get().getComments();
        comments.add(commentDB);
        post.get().setComments(comments);
        postRepository.save(post.get());

//        Post post = postRepository.findById(postId).get();
//        comment.setPost(post);
//        commentRepository.save(comment);

    }

    public Comment getCommentById(Long commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        return comment.get();
    }

    public void updateComment(Comment editedComment) {
        commentRepository.save(editedComment);
    }

    public void deleteComment(Long commentId, Long postID) {
      Post post =  postRepository.findById(postID).get();
      Comment comment = commentRepository.findById(commentId).get();
      post.getComments().remove(comment);
        commentRepository.deleteById(commentId);
    }
}
