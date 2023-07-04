package com.example.unittesting;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

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
}
