package com.doclink.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BannerAnnouncement")
@DiscriminatorColumn(name = "type",discriminatorType = DiscriminatorType.STRING)
public class BannerAnnouncement extends Post {
    public BannerAnnouncement() {
        super();
    }

    @Override
    public PostType getType() {
        return PostType.BannerAnnouncement;
    }
}
