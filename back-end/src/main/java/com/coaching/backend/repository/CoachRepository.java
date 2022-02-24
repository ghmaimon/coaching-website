package com.coaching.backend.repository;

import com.coaching.backend.model.Client;
import com.coaching.backend.model.Coach;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoachRepository extends UserRepository<Coach>{

    @Query("select c.client.id, c.client.firstName, c.client.lastName from Contract c where c.offer.coach.id = :coach")
    public List<Client> findClientByCoach(@Param("coach") Long coach);
}
