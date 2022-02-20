package com.coaching.backend.repository;

import com.coaching.backend.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    Optional<List<Offer>> findAllByTagsIn(List<String> tags);
}
