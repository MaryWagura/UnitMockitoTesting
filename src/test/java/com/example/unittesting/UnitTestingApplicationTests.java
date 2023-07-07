package com.example.unittesting;

import com.example.unittesting.controller.HelloWorldController;
import com.example.unittesting.controller.ItemController;
import com.example.unittesting.model.Item;
import com.example.unittesting.service.ItemBusinessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@WebMvcTest(HelloWorldController.class)
@WebMvcTest(ItemController.class)
class UnitTestingApplicationTests {

	@Autowired
	MockMvc mockMvc;
	@MockBean
	private ItemBusinessService itemBusinessService;
	@Test
	void contextLoads() {
	}
	@Test
	public void helloWorldControllerTest() throws Exception {
		//build GET request
		RequestBuilder request = MockMvcRequestBuilders.
				get("/hello-world").
				accept(MediaType.APPLICATION_JSON);
		//call the "/hello-world"
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World"))
				.andReturn();
		//verify the hello-world
		assertEquals("Hello World", result.getResponse().getContentAsString());

	}
	@Test
	public void dummyItemControllerTest() throws Exception {
		//build GET request
		RequestBuilder request = MockMvcRequestBuilders.
				get("/dummy-item").
				accept(MediaType.APPLICATION_JSON);
		//call the "/hello-world"
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
				.andReturn();
		//verify the hello-world
	//	assertEquals("Hello World", result.getResponse().getContentAsString());

	}
	@Test
	public void itemFromBusinessService_basic() throws Exception {
		when(itemBusinessService.retrieveHardcodedItem()).thenReturn(
				new Item(1, "Ball", 10,100));
		//build GET request
		RequestBuilder request = MockMvcRequestBuilders.
				get("/item-from-business-service").
				accept(MediaType.APPLICATION_JSON);
		//call the "/hello-world"
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
				.andReturn();
	}
	@Test
	public void retrieveAllItems_basic() throws Exception {
		when(itemBusinessService.retrieveAllItems()).thenReturn(
				(Arrays.asList(new Item(1, "Item2", 10, 100),
						        new Item (3, "Item3", 10,100))));
				//build GET request
				RequestBuilder request = MockMvcRequestBuilders.
				get("/all-items-from-database").
				accept(MediaType.APPLICATION_JSON);

				MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"id\":1,\"name\":\"Item2\",\"price\":10,\"quantity\":100},{\"id\":3,\"name\":\"Item3\",\"price\":10,\"quantity\":100}]"))
				.andReturn();
	}
}
