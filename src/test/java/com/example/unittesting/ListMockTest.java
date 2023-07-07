package com.example.unittesting;


import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {
	List mock = Mockito.mock(List.class);
	@Test
	public void size_basic(){

		when(mock.size()).thenReturn(5);
		assertEquals(5,mock.size());
	}
	@Test
	public void returnDifferentValues(){
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5,mock.size());
		assertEquals(10,mock.size());
	}
	@Test
	public void returnWithParameters(){
		when(mock.get(0)).thenReturn("in20mins");
		assertEquals("in20mins",mock.get(0));
		//in position 0 to return "in20mins" else return null for other positions
		assertEquals(null,mock.get(1));
	}
	@Test
	public void returnWithGenericParameters(){
		when(mock.get(anyInt())).thenReturn("in20mins");
		assertEquals("in20mins",mock.get(0));
		assertEquals("in20mins",mock.get(1));
	}
	@Test
	public void verificationBasics(){
		String value1= (String) mock.get(0);
		String value2 = (String) mock.get(1);

		//verify
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);
	}
	@Test
	public void argumentCapturing(){
		//sut
		mock.add("SomeString");

		//verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());

		assertEquals("SomeString", captor.getValue());
	}
	@Test
	public void multipleArgumentCapturing(){
		//sut
		mock.add("SomeString1");
		mock.add("SomeString2");

		//verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());

		List<String> allValues = captor.getAllValues();
		assertEquals("SomeString1", allValues.get(0));
		assertEquals("SomeString2", allValues.get(1));
	}

	//SPYING  >>> uses the real class
	@Test
	public void mocking(){
		ArrayList arrayListMock =mock(ArrayList.class);
		arrayListMock.get(0); //null
		arrayListMock.size();
		arrayListMock.add("Test2");
		when(arrayListMock.size()).thenReturn(5);
	}
	//SPYING  >>> uses the real class
	@Test
	public void spying(){
		ArrayList arrayListSpy =spy(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0)); //Test0
		System.out.println(arrayListSpy.size());
		arrayListSpy.add("Test2");
		when(arrayListSpy.size()).thenReturn(5);
	}
}
