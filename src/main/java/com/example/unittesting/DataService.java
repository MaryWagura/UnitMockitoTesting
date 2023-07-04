package com.example.unittesting;

import lombok.Data;
import org.springframework.stereotype.Service;

public interface DataService {
	int[] retrieveAllData();
	int[] retrieveEmpty();

	int[] retrieveOneValue();
}
