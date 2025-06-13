package com.java.ims;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.java.ims.entity.Client;
import com.java.ims.entity.Policy;

public class ClientTest {
	 
	@Test
	    public void testClientToString() {
	        Policy policy = new Policy();
	        Client client = new Client(1, "Harsh", "harsh@email.com", policy);
	        
	        String expected = "Client(clientId=1, clientName=Harsh, contactInfo=harsh@email.com, policy=" + policy.toString() + ")";
	        assertEquals(expected, client.toString());
	    }


    @Test
    public void testClientSettersAndGetters() {
        Policy policy = new Policy();
        Client client = new Client();

        client.setClientId(2);
        client.setClientName("avinash");
        client.setContactInfo("avinash@email.com");
        client.setPolicy(policy);

        assertEquals(2, client.getClientId());
        assertEquals("avinash", client.getClientName());
        assertEquals("avinash@email.com", client.getContactInfo());
        assertEquals(policy, client.getPolicy());
    }
    
	 @Test
	    public void testClientConstructor() {
	        Policy policy = new Policy();  
	        Client client = new Client(1, "Harsh", "harsh@email.com", policy);

	        assertEquals(1, client.getClientId());
	        assertEquals("Harsh", client.getClientName());
	        assertEquals("harsh@email.com", client.getContactInfo());
	        assertEquals(policy, client.getPolicy());
	    }

	


}
