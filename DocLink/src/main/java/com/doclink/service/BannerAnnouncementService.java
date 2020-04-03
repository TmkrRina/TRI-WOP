package com.doclink.service;

import com.doclink.model.BannerAnnouncement;
import com.doclink.repositories.BannerAnnouncementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.doclink.model.Post;

@Service
public class BannerAnnouncementService extends PostService implements IPost {
    @Autowired
    private BannerAnnouncementRepo bannerAnnouncementRepo;

    @Override
    public BannerAnnouncement create(Post post, Long id) {
        BannerAnnouncement bannerAnnouncement = (BannerAnnouncement) post;
        bannerAnnouncement.setDescription(bannerAnnouncement.getDescription());
        bannerAnnouncement.setDate(bannerAnnouncement.getDate());
        bannerAnnouncement.setUser(getUser(id));
        bannerAnnouncementRepo.save(bannerAnnouncement);
        return bannerAnnouncement;
    }


    @Override
    public BannerAnnouncement update(Post announcement) {
        BannerAnnouncement oldAnnouncement = bannerAnnouncementRepo.findById(announcement.getId()).get();

        oldAnnouncement.setTitle(announcement.getTitle());
        oldAnnouncement.setDescription(announcement.getDescription());

        bannerAnnouncementRepo.save(oldAnnouncement);

        return oldAnnouncement;
    }
}
