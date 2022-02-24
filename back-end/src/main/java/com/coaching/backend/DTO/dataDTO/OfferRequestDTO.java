package com.coaching.backend.DTO.dataDTO;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public record OfferRequestDTO(
        List<String> tags,
        @NotNull(message = "Title is required")
        @NotEmpty(message = "Title should not be empty")
        String title,
        @NotNull(message = "Description is required")
        String description,
        long minPrice,
        long maxPrice,
        MultipartFile image
) {
        public OfferRequestDTO(List<String> tags, @NotNull(message = "Title is required")
        @NotEmpty(message = "Title should not be empty")
                String title, @NotNull(message = "Description is required")
                                       String description, long minPrice, long maxPrice, MultipartFile image) {
                this.tags = tags;
                this.title = title;
                this.description = description;
                this.minPrice = minPrice;
                this.maxPrice = maxPrice;
                this.image = image;
        }

}
