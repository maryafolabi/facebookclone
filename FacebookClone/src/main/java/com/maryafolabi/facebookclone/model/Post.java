package com.maryafolabi.facebookclone.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postID;
    private String body;
    @ManyToOne
    @JoinColumn(name="userID")
    private User user;

    @OneToMany
    private List<Comment> comments = new ArrayList<>();
}