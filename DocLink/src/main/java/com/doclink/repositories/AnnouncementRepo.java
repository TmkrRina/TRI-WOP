package com.doclink.repositories;

import com.doclink.model.Announcement;
import org.springframework.data.repository.CrudRepository;

public interface AnnouncementRepo extends CrudRepository<Announcement, Long> {
}
