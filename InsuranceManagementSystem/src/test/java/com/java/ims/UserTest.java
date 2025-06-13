package com.java.ims;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.java.ims.entity.User;


public class UserTest {

	 @Test
	    public void testToString() {
		 User user = new User();
		    user.setUserId(1);
		    user.setUsername("Harsh");
		    user.setPassword("password");
		    user.setRole("admin");

		    String expected = "User(userId=1, username=Harsh, password=password, role=admin)";
		    assertEquals(expected, user.toString());
	    }

	    @Test
	    public void testGettersAndSetters() {
	        User user = new User();
	        user.setUserId(2);
	        user.setUsername("Christina");
	        user.setPassword("pass456");
	        user.setRole("user");

	        assertEquals(2, user.getUserId());
	        assertEquals("Christina", user.getUsername());
	        assertEquals("pass456", user.getPassword());
	        assertEquals("user", user.getRole());
	    }

	    @Test
	    public void testConstructor() {
	        User user = new User(3, "Aman", "securePass", "viewer");
	        assertEquals(3, user.getUserId());
	        assertEquals("Aman", user.getUsername());
	        assertEquals("securePass", user.getPassword());
	        assertEquals("viewer", user.getRole());
	    }
}
