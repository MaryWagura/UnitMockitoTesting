package com.example.unittesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataServiceStub implements DataService {
	@Override
	public int[] retrieveAllData(){
		return new int [] {1,2,3};
	}
	@Override
	public int[] retrieveEmpty(){
		return new int [] {0};
	}
	@Override
	public int[] retrieveOneValue(){
		return new int [] {3};
	}
}
public class BusinessStubTest {
	DataService dataService;
	@Test
	public void calculateSumUsingDataService(){
		BusinessImpl business = new BusinessImpl();
		business.setDataService(new DataServiceStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult =6;
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void calculateSumUsingDataService_empty(){
		BusinessImpl business = new BusinessImpl();
		business.setDataService(new DataServiceStub());
		int actualResult = business.calculateSumUsingEmpty();
		int expectedResult =0;
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void calculateSumUsingDataService_oneValue(){
		BusinessImpl business = new BusinessImpl();
		business.setDataService(new DataServiceStub());
		int actualResult = business.calculateSumUsingOneValue();
		int expectedResult =3;
		assertEquals(expectedResult, actualResult);
	}
}
