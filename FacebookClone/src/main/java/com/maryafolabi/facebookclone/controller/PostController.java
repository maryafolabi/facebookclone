package com.maryafolabi.facebookclone.controller;


import com.maryafolabi.facebookclone.model.Comment;
import com.maryafolabi.facebookclone.model.Post;
import com.maryafolabi.facebookclone.model.User;
import com.maryafolabi.facebookclone.service.serviceimplementation.CommentServiceImplementation;
import com.maryafolabi.facebookclone.service.serviceimplementation.PostServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class PostController {

    PostServiceImplementation postServiceImplementation;
    CommentServiceImplementation commentServiceImplementation;

    @Autowired
    public PostController(PostServiceImplementation postServiceImplementation, CommentServiceImplementation commentServiceImplementation) {
        this.postServiceImplementation = postServiceImplementation;
        this.commentServiceImplementation = commentServiceImplementation;
    }

    @GetMapping("/")
    public String retrievePosts(Model model) {
        Iterable<Post> posts = postServiceImplementation.getAllPost();
        Iterable<Comment> comments = commentServiceImplementation.getAllComment();
        model.addAttribute("allPosts", posts);
        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", comments);
        model.addAttribute("post",new Post());
        return "home";
    }

    @PostMapping("/createPost")
    // method to create a new post
    public String createNewPost(@ModelAttribute("post") Post post, HttpServletRequest request){
        // create a session object
       User loggedInUser = (User) request.getSession().getAttribute("userSession");

        System.out.println("I am here" +  loggedInUser);
        // save the new post
        postServiceImplementation.addPost(post.getBody(), loggedInUser);
        return "redirect:/";

    }

    @GetMapping("/delete/{id}")
    // method to delete a post
    public String deletePost(@PathVariable(name = "id")Long postId) {
        postServiceImplementation.deletePost(postId);
        return "redirect:/";
    }

    // method to render the edit post page

    @GetMapping("/edit/{id}")
    public String showEditPost(@PathVariable(name = "id") Long postID, Model model){
         // get the post from the database
        Post post = postServiceImplementation.getPostById(postID);
        model.addAttribute("post", post);
        return "editPosts";
    }

    @PostMapping("/edit")
    //method to update a post
    public String editPost(@ModelAttribute("post") Post editedPost){
         postServiceImplementation.updatePost(editedPost);
        return "redirect:/";
    }
}
