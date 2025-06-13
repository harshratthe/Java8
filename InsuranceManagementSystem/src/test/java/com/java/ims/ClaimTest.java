package com.java.ims;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import com.java.ims.entity.Claim;
import com.java.ims.entity.Client;
import com.java.ims.entity.Policy;

public class ClaimTest {
	@Test
	public void testClaimToString() {
	    Date date = new Date();
	    Policy policy = new Policy();
	    Client client = new Client();

	    Claim claim = new Claim(1, "CLM-1001", date, 5000.0, "Pending", policy, client);
	    
	    String expected = "Claim(claimId=1, claimNumber=CLM-1001, dateFiled=" + date.toString()
	            + ", claimAmount=5000.0, status=Pending, policy=" + policy.toString()
	            + ", client=" + client.toString() + ")";
	    
	    assertEquals(expected, claim.toString());
	}

	    @Test
	    public void testClaimSettersAndGetters() {
	        Claim claim = new Claim();

	        Date date = new Date();
	        Policy policy = new Policy();
	        Client client = new Client();

	        claim.setClaimId(2);
	        claim.setClaimNumber("CLM-2002");
	        claim.setDateFiled(date);
	        claim.setClaimAmount(7500.0);
	        claim.setStatus("Approved");
	        claim.setPolicy(policy);
	        claim.setClient(client);

	        assertEquals(2, claim.getClaimId());
	        assertEquals("CLM-2002", claim.getClaimNumber());
	        assertEquals(date, claim.getDateFiled());
	        assertEquals(7500.0, claim.getClaimAmount(), 0.01);
	        assertEquals("Approved", claim.getStatus());
	        assertEquals(policy, claim.getPolicy());
	        assertEquals(client, claim.getClient());
	    }
	    @Test
	    public void testClaimConstructor() {
	        Date date = new Date();
	        Policy policy = new Policy(); 
	        Client client = new Client(); 

	        Claim claim = new Claim(1, "CLM-1001", date, 5000.0, "Pending", policy, client);

	        assertEquals(1, claim.getClaimId());
	        assertEquals("CLM-1001", claim.getClaimNumber());
	        assertEquals(date, claim.getDateFiled());
	        assertEquals(5000.0, claim.getClaimAmount(), 0.01);
	        assertEquals("Pending", claim.getStatus());
	        assertEquals(policy, claim.getPolicy());
	        assertEquals(client, claim.getClient());
	    }
	   }
	
	

