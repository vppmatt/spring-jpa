package com.example.demoadvancedtesting.controller;

import com.example.demoadvancedtesting.model.Item;
import com.example.demoadvancedtesting.service.ItemService;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class) // use this annotation on any controller layer test class
class ItemControllerTest {

    // to test dummyItem() we need to send a GET request to /dummy-item
    // and we then need to check the result and compare it against Item[1,"Ball",10,100]
    // To send a request to any endpoint we can use an object called MockMVC

    private MockMvc mockMvc;


    // @Mock is not possible to be used here because @ExtendWith(MockitoExtension.class) is not defined
    // on top of the class
    // Instead @WebMvcTest provides us with another annotation called @MockBean

    @MockBean // not only mocks an object, but also injects it automatically for us
    private ItemService service;


    @Autowired
    public ItemControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void dummyItem_shouldReturnBall() throws Exception {
        // given
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")  // Request Method: GET
                .accept(MediaType.APPLICATION_JSON); // Request Header: accept

        // when & then
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100,\"value\":0}"));

    }

    @Test
    public void itemFromService_shouldReturnHardcodedItem() throws Exception {
        when(service.retrieveHardcodedItem()).thenReturn(new Item(2, "Item2", 10, 10));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-service")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":2,\"name\":\"Item2\",\"price\":10,\"quantity\":10,\"value\":0}"));
    }


    @Test
    public void retrieveAllItems_shouldReturnAllItems() throws Exception {
        when(service.retrieveAllItems()).thenReturn(
                Arrays.asList(new Item(2, "Item2", 10, 10),
                        new Item(3, "Item3", 20, 20))
        );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json
                        ("[" +
                                "{id:2,name:Item2,price:10,quantity:10,value:0}," +
                                "{id:3,name:Item3,price:20,quantity:20,value:0}" +
                                "]"));
    }

}