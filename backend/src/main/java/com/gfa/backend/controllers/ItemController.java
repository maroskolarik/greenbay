package com.gfa.backend.controllers;

import com.gfa.backend.dtos.ErrorResponseDto;
import com.gfa.backend.dtos.ItemRequestDto;
import com.gfa.backend.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/items")
    public ResponseEntity create(@RequestBody ItemRequestDto dto) {
        //TODO validate input data
        return ResponseEntity.status(200).body(itemService.createItem(dto));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDto> illegalArgumentExceptionHandler(Exception e){
        return ResponseEntity.status(400).body(new ErrorResponseDto(e.getMessage()));
    }
}
