package com.hw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class ServiceTest {
	@Test
	public void testCalFinalPrice1() {
		Discount repo = mock(Discount.class);
		when(repo.getDiscountPercentage("MOB")).thenReturn(10.0);
		
		Discount repo1 = mock(Discount.class);
		when(repo.getDiscountPercentage("LAP")).thenReturn(20.0);
		
		
		Service obj = new Service(repo);
		
		double res = obj.calFinalPrice(1000,"MOB");
		assertEquals(900, res);
		
		
	}
	@Test
	public void testCalFinalPrice2() {
		
		
		Discount repo = mock(Discount.class);
		when(repo.getDiscountPercentage("LAP")).thenReturn(20.0);
		
		
		Service obj = new Service(repo);
		
		double res = obj.calFinalPrice(2000,"LAP");
		assertEquals(1600, res);
		
		
	}
		

}