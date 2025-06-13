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

public class Client {

	  private int clientId;
	    private String clientName;
	    private String contactInfo;
	    private Policy policy;
}
