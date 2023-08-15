package com.gfa.backend.services;

import com.gfa.backend.dtos.ItemRequestDto;
import com.gfa.backend.dtos.ItemResponseDto;
import com.gfa.backend.models.Item;

public interface ItemService {
    ItemResponseDto createItem(ItemRequestDto dto);
}
