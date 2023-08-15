package com.gfa.backend.services;

import com.gfa.backend.dtos.ItemRequestDto;
import com.gfa.backend.dtos.ItemResponseDto;
import com.gfa.backend.models.Item;
import com.gfa.backend.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseItemService implements ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public DatabaseItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemResponseDto createItem(ItemRequestDto dto) {
        if (dto == null) throw new IllegalArgumentException("Request body is empty");
        if (dto.getName() == null || dto.getName().isEmpty()) throw new IllegalArgumentException("Name is required");
        if (dto.getDescription() == null || dto.getDescription().isEmpty()) throw new IllegalArgumentException("Description is required");
        if (dto.getPhotoUrl() == null || dto.getPhotoUrl().isEmpty()) throw new IllegalArgumentException("Photo url is required");
        if (dto.getStartingPrice() == null) throw new IllegalArgumentException("Starting price is required");
        if (dto.getPurchasePrice() == null) throw new IllegalArgumentException("Purchase price is required");
        if (dto.getStartingPrice() <= 0 || dto.getPurchasePrice() <= 0) throw new IllegalArgumentException("Price must be a positive number");
        if (!dto.getPhotoUrl().matches("^(http(s):\\/\\/.)[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)$")) {
            throw new IllegalArgumentException("Invalid photo url");
        }
        Item item = itemRepository.save(new Item(dto.getName(), dto.getDescription(), dto.getPhotoUrl(), dto.getStartingPrice(), dto.getPurchasePrice()));
        return new ItemResponseDto(item.getId(), item.getName(), item.getDescription(), item.getPhotoUrl(), item.getStartingPrice(), item.getPurchasePrice());
    }
}
