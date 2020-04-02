package com.doclink.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.doclink.model.Post;
import com.doclink.model.User;
import com.doclink.repositories.UserRepo;

import lombok.Data;

@Data
public class BannerAnnouncementDTO {
	@Autowired
	UserRepo userRepo;

	public BannerAnnouncementDTO(Post post) {

		this.description = post.getDescription();
		this.date = post.getDate();

	}

	private String description;
	private String date;
	private User user;

	private void BannerAnnouncementDTO() {
		// TODO Auto-generated method stub

	}

}
