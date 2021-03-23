package com.example.Authentication;


import com.example.Authentication.entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class EntityTests {
	@Test
	public void WhenSetPassword_CheckGetPassword() {
		User testUser = new User();
		testUser.setPassword("mypassword");
		assertEquals(testUser.getPassword(),"mypassword");
		assertNotEquals(testUser.getPassword(),"mypassword2");
	}
	@Test
	public void WhenSetEmail_CheckGetEmail() {
		User testUser = new User();
		
		testUser.setEmail("emailTest@gmail.com");
		assertEquals(testUser.getEmail(),"emailTest@gmail.com");
		assertNotEquals(testUser.getEmail(),"emailTest@yahoo.com");
	}
	@Test
	public void WhenSetName_CheckGetName() {
		User testUser = new User();
		
		testUser.setName("nameTest");
		assertEquals(testUser.getName(),"nameTest");
		assertNotEquals(testUser.getName(),"nameTest2");
	}
	@Test
	public void WhenSetId_CheckGetId() {
		User testUser = new User();
		
		testUser.setId(1);
		assertEquals(testUser.getId(),1);
		assertNotEquals(testUser.getId(),2);
	}
	
}