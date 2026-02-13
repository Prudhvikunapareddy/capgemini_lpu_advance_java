package com.pracmockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class UserServiceTest {
	@Test
 public void testGetTypeOfCustomer() {
	 UserDao userdao = new UserDao();
	 UserService userService = new UserService(userdao);
	 userService.typeOfUser(1);
	 String actualRes = userService.typeOfUser(1);
	 assertEquals("regular user",actualRes);
 }
	@Test
	public void testDoubleAddition() {
		//Step 1: createFakeObject
		Calculator calmock = mock(Calculator.class);
		//step 2 : what mock object should return
		
		when(calmock.add(5,5)).thenReturn(20);
		
		//step 3 : inject the mock  reference
		
		MathService service = new MathService(calmock);
		int res = service.doubleAddition(5, 5);
		
		assertEquals(20,res);
	}
}
