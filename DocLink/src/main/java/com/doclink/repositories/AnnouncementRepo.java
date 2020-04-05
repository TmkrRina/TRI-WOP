package com.doclink.repositories;

import org.springframework.data.repository.CrudRepository;

import com.doclink.model.Announcement;

public interface AnnouncementRepo extends CrudRepository<Announcement, Long> {
	
}
