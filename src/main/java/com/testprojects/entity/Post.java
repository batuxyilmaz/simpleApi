package com.testprojects.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name="post")
public class Post {
    @Id
    long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) // if one user deleted. Delete all the post belongs that user
    @JsonIgnore
    User user;

    String title;

    @Lob
    @Column(columnDefinition = "text")
    String text;
}
