package com.doclink.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name = "post")
@DiscriminatorValue(value = "HealthIssue")
@DiscriminatorColumn(name = "type",discriminatorType = DiscriminatorType.STRING)
public class HealthIssue extends Post {
	



    public HealthIssue() {
    	 super();
    }

    @Override
    public PostType getType() {
        return PostType.HealthIssue;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Comment> comments;

}
