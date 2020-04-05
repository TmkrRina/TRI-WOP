package com.doclink.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "post")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type",discriminatorType = DiscriminatorType.STRING)

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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "post", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Comment> comments;

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
