package com.example.demoadvancedtesting.service;

import com.example.demoadvancedtesting.model.Item;
import com.example.demoadvancedtesting.repository.ItemRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock
    private ItemRepository repository;

    @InjectMocks
    private ItemService service;  //SUT

    // Test method names should be as descriptive as possible
    // Test method names are usually very long and this is the only place that
    // having long method names is accepted and it is NOT a bad practice
    // Try to use descriptive names

    @Test
    public void retrieveAllItems_shouldReturnAllItemsInDB() {
        // given
        when(repository.findAll())
                .thenReturn(Arrays.asList(
                        new Item(2, "Item2", 10, 10),
                        new Item(3, "Item3", 20, 20))
                );

        // when
        List<Item> items = service.retrieveAllItems();

        // then
        assertEquals("Item2", items.get(0).getName());
        assertEquals(100, items.get(0).getValue());

        assertEquals("Item3", items.get(1).getName());
        assertEquals(400, items.get(1).getValue());
    }


    // As a point to consider when starting to write tests,
    // always try to think in 3 steps:
    // 1. GIVEN -> 2. WHEN -> 3. THEN
    // Most of the tests you'd write will fit in this template

    @Test
    public void retrieveHardcodedItem_shouldReturnBall() {

//         given
        // given we have a SUT

//        when
        Item item = service.retrieveHardcodedItem();

//        then
        assertEquals( "Ball", item.getName());
        assertEquals( 1, item.getId());
    }
}