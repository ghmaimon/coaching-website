package com.coaching.backend.DTO.dataDTO;

import com.coaching.backend.model.Coach;
import com.coaching.backend.model.Offer;
import com.coaching.backend.utils.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public record OfferDTO(
        Long id,
        CoachBasicInformationDTO coachBasicDTO,
        List<String> tags,
        @NotNull(message = "Title is required")
        @NotEmpty(message = "Title should not be empty")
        String title,
        @NotNull(message = "Description is required")
        String description,
        long minPrice,
        long maxPrice,
        Date creationDate,
        String image
) {

        public OfferDTO(Long id, CoachBasicInformationDTO coachBasicDTO, List<String> tags, @NotNull(message = "Title is required")
        @NotEmpty(message = "Title should not be empty")
                String title, @NotNull(message = "Description is required")
                                String description, long minPrice, long maxPrice, Date creationDate, String image) {
                this.id = id;
                this.coachBasicDTO = coachBasicDTO;
                this.tags = tags;
                this.title = title;
                this.description = description;
                this.minPrice = minPrice;
                this.maxPrice = maxPrice;
                this.creationDate = creationDate;
                this.image = image;
        }

        public OfferDTO(Offer offer) {
                this(
                        offer.getId(),
                        new CoachBasicInformationDTO(offer.getCoach()),
                        offer.getTags(),
                        offer.getTitle(),
                        offer.getDescription(),
                        offer.getMinPrice(),
                        offer.getMaxPrice(),
                        offer.getCreationDate(),
                        offer.getImage()
                );
        }
}
