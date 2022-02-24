package com.coaching.backend.DTO.dataDTO;

import com.coaching.backend.utils.MyConverter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Converter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Convert;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public record OfferRequestDTO(
        String tags,
        @NotNull(message = "Title is required")
        @NotEmpty(message = "Title should not be empty")
        String title,
        @NotNull(message = "Description is required")
        String description,
        long minPrice,
        long maxPrice,
        MultipartFile image
) {
        public OfferRequestDTO( String tags, @NotNull(message = "Title is required")
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
