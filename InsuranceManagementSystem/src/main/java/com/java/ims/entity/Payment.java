package com.java.ims.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Payment {

	private int paymentId;
    private Date paymentDate;
    private double paymentAmount;
    private Client client;
	
}
