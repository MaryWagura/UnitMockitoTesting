package com.example.unittesting;

import com.example.unittesting.data.ItemRepository;
import com.example.unittesting.model.Item;
import com.example.unittesting.service.ItemBusinessService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DataJdbcTest
public class ItemRepositoryTest {
    @Mock
    private ItemBusinessService itemBusinessService;
    @Mock
    private ItemRepository repository;
    @Test
    public void testFindAll(){
        when(itemBusinessService.retrieveAllItems()).thenReturn(Arrays.asList(
                new Item(1, "Item2", 10, 100)));
        assertEquals(Arrays.asList(new Item(1, "Item2", 10, 100)),itemBusinessService.retrieveAllItems());
//        List<Item> items = repository.findAll();
//        assertEquals(3, items.size());
    }
}

