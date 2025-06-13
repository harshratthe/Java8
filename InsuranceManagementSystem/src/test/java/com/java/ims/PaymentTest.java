package com.java.ims;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import com.java.ims.entity.Client;
import com.java.ims.entity.Payment;

public class PaymentTest {
          
	
	@Test
    public void testPaymentToString() {
        Date date = new Date();
        Client client = new Client();
        Payment payment = new Payment(1, date, 9999.99, client);

        String expected = "Payment(paymentId=1, paymentDate=" + date.toString()
                + ", paymentAmount=9999.99, client=" + client.toString() + ")";
        assertEquals(expected, payment.toString());
    }
	
	  @Test
	    public void testPaymentSettersAndGetters() {
	        Date date = new Date();
	        Client client = new Client();
	        Payment payment = new Payment();

	        payment.setPaymentId(2);
	        payment.setPaymentDate(date);
	        payment.setPaymentAmount(5000.0);
	        payment.setClient(client);

	        assertEquals(2, payment.getPaymentId());
	        assertEquals(date, payment.getPaymentDate());
	        assertEquals(5000.0, payment.getPaymentAmount(), 0.01);
	        assertEquals(client, payment.getClient());
	    }
	
	 @Test
	    public void testPaymentConstructor() {
	        Date date = new Date();
	        Client client = new Client();
	        Payment payment = new Payment(1, date, 9999.99, client);

	        assertEquals(1, payment.getPaymentId());
	        assertEquals(date, payment.getPaymentDate());
	        assertEquals(9999.99, payment.getPaymentAmount(), 0.01);
	        assertEquals(client, payment.getClient());
	    }

	 

	  
}
