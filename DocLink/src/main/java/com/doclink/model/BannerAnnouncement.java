package com.doclink.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BannerAnnouncement")
public class BannerAnnouncement extends Post {
    public BannerAnnouncement() {
        super();
    }

    @Override
    public PostType getType() {
        return PostType.BannerAnnouncement;
    }
}
