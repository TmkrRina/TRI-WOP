package com.doclink.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue(value = "Announcement")
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Announcement extends Post {
   

    public Announcement() {
    	super();
    }


    @Override()
    public PostType getType() {
        return PostType.Announcement;
    }
}
