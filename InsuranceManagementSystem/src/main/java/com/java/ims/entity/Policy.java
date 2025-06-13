package com.java.ims.entity;

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

public class Policy {
	private int policyId;
    private String policyName;
    private String policyType;
    private double coverageAmount;
    private double premiumAmount;
}
