package com.example.unittesting;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BusinessMockTest {
    @InjectMocks
	BusinessImpl business = new BusinessImpl();
	@Mock
	DataService dataServiceMock= mock(DataService.class);
	//***global variable***
	//	@BeforeAll
	//	public void before(){
	//		business.setDataService(dataServiceMock);
	//	}
	//
	@Test
	public void calculateSumUsingDataService_basic(){
		//retrieveAllData new int[] {1,2,3}
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
		business.setDataService(dataServiceMock);
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult =6;
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void calculateSumUsingDataService_empty(){
        when(dataServiceMock.retrieveEmpty()).thenReturn(new int[] {0});
		business.setDataService(dataServiceMock);
		int actualResult = business.calculateSumUsingEmpty();
		int expectedResult =0;
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void calculateSumUsingDataService_oneValue(){
		when(dataServiceMock.retrieveOneValue()).thenReturn(new int[]{4});
		business.setDataService(dataServiceMock);
		int actualResult = business.calculateSumUsingOneValue();
		int expectedResult =4;
		assertEquals(expectedResult, actualResult);
	}
}
