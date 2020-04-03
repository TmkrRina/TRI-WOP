package com.doclink.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "post")
@DiscriminatorColumn(name = "type")
public abstract class Post implements Serializable {

    public Post(Long id, String title, String description, String date, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.user = user;
    }

    public Post() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public abstract PostType getType();

    public User getUser() {
        return user;
    }

    public static Post create(PostType type) {
        switch (type) {
            case HealthIssue:
                return new HealthIssue();
            case Announcement:
                return new Announcement();
            case BannerAnnouncement:
                return new BannerAnnouncement();
        }

        return null;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private String description;
    private String date;

    @ManyToOne
    private User user;

}

