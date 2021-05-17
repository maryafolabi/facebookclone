package com.maryafolabi.facebookclone.controller;


import com.maryafolabi.facebookclone.model.Comment;
import com.maryafolabi.facebookclone.repository.CommentRepository;
import com.maryafolabi.facebookclone.service.serviceimplementation.CommentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@Controller
public class CommentController {

    @Autowired
    CommentServiceImplementation commentServiceImplementation;

    @Autowired
    CommentRepository commentRepository;

    @PostMapping("/comment/{id}")
    public String addComment(@ModelAttribute("comment") Comment comment, @PathVariable(name = "id") Long postId) {
        commentServiceImplementation.saveComment(comment, postId);
        return "redirect:/";
        }

    @GetMapping("/update/{id}")
    public String editComment(@PathVariable(name = "id") Long commentId, Model model) {
        Comment comment = commentServiceImplementation.getCommentById(commentId);
        model.addAttribute("comment", comment);
        return "editComments";
    }

    @PostMapping("/update")
    public String editComment(@ModelAttribute("comments") Comment editedComment) {
        Optional<Comment> comment = commentRepository.findById(editedComment.getId());
        comment.get().setBody(editedComment.getBody());
        commentRepository.save(editedComment);
        return "redirect:/";
    }

    @GetMapping("/deleteComment/{id}/{postID}")
    public String deleteComment(@PathVariable(name = "id") Long commentId, @PathVariable(name = "postID") Long postId) {
        commentServiceImplementation.deleteComment(commentId, postId);
        return "redirect:/";
    }
}
