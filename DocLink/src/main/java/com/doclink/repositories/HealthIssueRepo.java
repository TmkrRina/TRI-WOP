package com.doclink.repositories;

import com.doclink.model.HealthIssue;
import org.springframework.data.repository.CrudRepository;

public interface HealthIssueRepo extends CrudRepository<HealthIssue, Long> {
    Iterable<HealthIssue> findByUserId(Long id);

}
