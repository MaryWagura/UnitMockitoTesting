package com.example.unittesting;

import lombok.Data;


public interface DataService {
	int[] retrieveAllData();
	int[] retrieveEmpty();

	int[] retrieveOneValue();
}
