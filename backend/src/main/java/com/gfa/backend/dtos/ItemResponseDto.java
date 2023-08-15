package com.gfa.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemResponseDto {
    private final Long id;
    private final String name;
    private final String description;
    @JsonProperty("photo_url")
    private final String photoUrl;
    @JsonProperty("starting_price")
    private final Integer startingPrice;
    @JsonProperty("purchase_price")
    private final Integer purchasePrice;

    public ItemResponseDto(Long id, String name, String description, String photoUrl, Integer startingPrice, Integer purchasePrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photoUrl = photoUrl;
        this.startingPrice = startingPrice;
        this.purchasePrice = purchasePrice;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public Integer getStartingPrice() {
        return startingPrice;
    }

    public Integer getPurchasePrice() {
        return purchasePrice;
    }
}
