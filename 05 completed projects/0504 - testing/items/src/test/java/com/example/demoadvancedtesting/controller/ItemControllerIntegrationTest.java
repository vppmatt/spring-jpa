package com.example.demoadvancedtesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // this annotation starts our spring context
public class ItemControllerIntegrationTest {
    // Integration testing is no longer about mocking/stubbing dependencies,
    // but we are testing if our components can talk to each other(aka integrate) properly.

    // Now, we need to send a GET request to /all-items-from-database endpoint from within our code
    // but we can't use mockMvc since here we have no mocking
    // Instead, spring provides us with TestRestTemplate object
    private TestRestTemplate restTemplate;

    @Autowired
    public ItemControllerIntegrationTest(TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Test
    public void retrieveAllItems_shouldReturn3ItemsFromDB() throws JSONException {
        String response = this.restTemplate.getForObject("/all-items-from-database", String.class);
        // using assertEquals for long responses is a bit messy. Instead better to use JSONAssert class
        //        assertEquals("[{\"id\":10001,\"name\":\"Item1\",\"price\":10,\"quantity\":20,\"value\":200},{\"id\":10002,\"name\":\"Item2\",\"price\":5,\"quantity\":10,\"value\":50},{\"id\":10003,\"name\":\"Item3\",\"price\":15,\"quantity\":20,\"value\":300}]"
        //                , response);

        JSONAssert.assertEquals("[{id:10001},{id:10002},{id:10003}]", response, false);
    }

    // TASK:
     /*
     Create another controller class called `HelloWorldController` which accepts any GET request to /hello-world
     endpoint and returns `Hello World`. Once the controller is working fine, try to write unit tests for it using `MockMvc`.
     */

    // TODO: Read more and practice these libraries
    /*
    * 1. AssertJ
    * 2. Hamcrest
    * 3. JsonAssert
    * 4. JsonPath
    * */
}
