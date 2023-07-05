package com.example.unittesting.service;

import com.example.unittesting.model.Item;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class ItemBusinessService {
    public Item retrieveHardcodedItem(){
        return new Item(1, "Ball",10,100);
    }

}
