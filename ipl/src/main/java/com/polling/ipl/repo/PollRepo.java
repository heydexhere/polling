package com.polling.ipl.repo;

import com.polling.ipl.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PollRepo extends JpaRepository<Poll, String> {
    boolean existsByTeamIgnoreCase(String team);

    Poll findByTeamIgnoreCase(String team);
}
