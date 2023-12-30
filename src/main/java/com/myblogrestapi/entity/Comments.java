package com.myblogrestapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name = "body")
    private String body;

    //mapping to post table @ManyToOne ie many comments and one post
    // and fetch=FetchType.LAZY will load only required table into the memory.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id", nullable=false) //creating foreign key name post_id in comments table
    private Post post;
}
