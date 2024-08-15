package com.psybooks.psybooksexportingservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psybooks.psybooksexportingservice.entity.dto.ItemDto;
import com.psybooks.psybooksexportingservice.repo.ItemRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/items/rest")
@RequiredArgsConstructor
public class ItemsController {
    private final ItemRepository itemRepository;

    @GetMapping("/get-items")
    public GetItemsResponse getAllItems(HttpServletRequest request) {
        List<ItemDto> list = itemRepository.findAll().stream().map(ItemDto::new).toList();
        return new GetItemsResponse(list);
    }

    public record GetItemsResponse(List<ItemDto> items) {
    }
}
