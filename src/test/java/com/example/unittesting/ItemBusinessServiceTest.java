package com.example.unittesting;

import com.example.unittesting.data.ItemRepository;
import com.example.unittesting.model.Item;
import com.example.unittesting.service.ItemBusinessService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {
    @InjectMocks
    private ItemBusinessService itemBusinessService;
    @Mock
    private ItemRepository repository;

    @Test
    public void calculateSumUsingDataService_basic(){
        //retrieveAllData
        when(repository.findAll()).thenReturn(Arrays.asList(
                new Item(1, "Item2", 10, 100),
                new Item (3, "Item3", 10,100)));
       List<Item> items= itemBusinessService.retrieveAllItems();
       assertEquals(1000,items.get(0).getValue());
        assertEquals(1000,items.get(1).getValue());
    }

}
