package com.gfa.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemRequestDto {
    private final String name;
    private final String description;
    @JsonProperty("photo_url")
    private final String photoUrl;
    @JsonProperty("starting_price")
    private final Integer startingPrice;
    @JsonProperty("purchase_price")
    private final Integer purchasePrice;

    public ItemRequestDto(String name, String description, String photoUrl, Integer startingPrice, Integer purchasePrice) {
        this.name = name;
        this.description = description;
        this.photoUrl = photoUrl;
        this.startingPrice = startingPrice;
        this.purchasePrice = purchasePrice;
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
