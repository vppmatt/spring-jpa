package com.example.demoadvancedtesting.controller;

import com.example.demoadvancedtesting.model.Item;
import com.example.demoadvancedtesting.service.ItemService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    private ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/item-from-service")
    public Item itemFromService() {
        return service.retrieveHardcodedItem();
    }

    @GetMapping("/all-items-from-database")
    public List<Item> retrieveAllItems() {
        return service.retrieveAllItems();
    }
}
