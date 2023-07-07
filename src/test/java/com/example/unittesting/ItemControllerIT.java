package com.example.unittesting;

import com.example.unittesting.data.ItemRepository;
import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Integration Test Layer")
public class ItemControllerIT {
    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean //to mock out external dependancies
    private ItemRepository itemRepository;
    @Test
    public void contextLoads() throws JSONException {
        String response = this.restTemplate.getForObject("all-items-from-database", String.class);
        JSONAssert.assertEquals("[{id:1001},{id:1002},{id:1003}]", response, false);

    }
}
