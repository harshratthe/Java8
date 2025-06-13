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

public class Claim {
   
	 private int claimId;
	    private String claimNumber;
	    private Date dateFiled;
	    private double claimAmount;
	    private String status;
	    private Policy policy;
	    private Client client;
}
