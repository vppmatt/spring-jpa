package com.example.demoadvancedtesting.service;

import com.example.demoadvancedtesting.model.Item;
import com.example.demoadvancedtesting.repository.ItemRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public Item retrieveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }

    public List<Item> retrieveAllItems() {
        List<Item> items = repository.findAll();
        // since items in DB are stored without a column for value field,
        // we have to calculate value manually ourselves and store them in every Item object
        for (Item i : items) {
            i.setValue(i.getPrice() * i.getQuantity());
        }

        return items;
    }
}
