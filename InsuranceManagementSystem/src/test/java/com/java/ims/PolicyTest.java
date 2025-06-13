package com.java.ims;

import static org.junit.Assert.*;


import org.junit.Test;

import com.java.ims.entity.Policy;

public class PolicyTest {
 
	@Test
    public void testToString() {
        Policy policy = new Policy(1, "Health", "Annual", 200000.0, 8000.0);
        String result = "Policy(policyId=1, policyName=Health, policyType=Annual, coverageAmount=200000.0, premiumAmount=8000.0)";
        assertEquals(result, policy.toString());
    }

    @Test
    public void testGettersAndSetters() {
        Policy policy = new Policy();
        policy.setPolicyId(101);
        policy.setPolicyName("Car Insurance");
        policy.setPolicyType("Comprehensive");
        policy.setCoverageAmount(300000.0);
        policy.setPremiumAmount(10000.0);

        assertEquals(101, policy.getPolicyId());
        assertEquals("Car Insurance", policy.getPolicyName());
        assertEquals("Comprehensive", policy.getPolicyType());
        assertEquals(300000.0, policy.getCoverageAmount(), 2);
        assertEquals(10000.0, policy.getPremiumAmount(), 2);
    }

    @Test
    public void testConstructor() {
        Policy policy = new Policy(102, "Travel", "SingleTrip", 100000.0, 3000.0);
        assertEquals(102, policy.getPolicyId());
        assertEquals("Travel", policy.getPolicyName());
        assertEquals("SingleTrip", policy.getPolicyType());
        assertEquals(100000.0, policy.getCoverageAmount(), 2);
        assertEquals(3000.0, policy.getPremiumAmount(), 2);
    }
	
}
