package com.example.demoadvancedtesting.repository;

import com.example.demoadvancedtesting.model.Item;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // is needed if you want your DB to be initialized on test start
class ItemRepositoryTest {

    private ItemRepository repository;

    @Autowired
    public ItemRepositoryTest(ItemRepository repository) {
        this.repository = repository;
    }

    @Test
    public void testFindAll() {
        List<Item> items = repository.findAll();
        assertEquals(3, items.size());
    }

    @Test
    public void testFindOne() {
        Item item = repository.findById(10001).get();
        assertEquals("Item1", item.getName());
    }
}