package com.doclink.service;

import com.doclink.model.Announcement;
import com.doclink.model.Post;
import com.doclink.repositories.AnnouncementRepo;
import com.doclink.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementService extends PostService implements IPost {

    @Autowired
    PostRepo postRepo;

    @Autowired
    AnnouncementRepo announcementRepo;


    @Override
    public Announcement create(Post post, Long userId) {
        Post announcement = post;
        announcement.setDescription(announcement.getDescription());
        announcement.setDate(announcement.getDate());
        announcement.setUser(getUser(userId));
        postRepo.save(announcement);
        return (Announcement) announcement;
    }


    @Override
    public Announcement update(Post announcement) {
        Announcement oldAnnouncement = announcementRepo.findById(announcement.getId()).get();

        oldAnnouncement.setTitle(announcement.getTitle());
        oldAnnouncement.setDescription(announcement.getDescription());

        announcementRepo.save(oldAnnouncement);

        return oldAnnouncement;
    }
}
