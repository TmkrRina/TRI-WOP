package com.doclink.service;

import com.doclink.model.HealthIssue;
import com.doclink.repositories.HealthIssueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doclink.model.Post;
import com.doclink.repositories.PostRepo;

@Service
public class HealthIssueService extends PostService implements IPost {

    @Autowired
    PostRepo postRepo;


    @Autowired
    HealthIssueRepo healthIssueRepo;


    @Override
    public HealthIssue create(Post post, Long userId) {
        Post bannerAnnouncement = post;
        bannerAnnouncement.setDescription(bannerAnnouncement.getDescription());
        bannerAnnouncement.setDate(bannerAnnouncement.getDate());
        bannerAnnouncement.setUser(getUser(userId));
        postRepo.save(bannerAnnouncement);
        return (HealthIssue) bannerAnnouncement;
    }

    @Override
    public HealthIssue update(Post healthIssue) {
        HealthIssue oldHealthIssue = healthIssueRepo.findById(healthIssue.getId()).get();

        oldHealthIssue.setTitle(healthIssue.getTitle());
        oldHealthIssue.setDescription(healthIssue.getDescription());

        postRepo.save(oldHealthIssue);

        return oldHealthIssue;
    }
}
