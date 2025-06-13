package com.java.ims.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.ims.entity.Policy;

public interface IPolicyService {
	
	  boolean createPolicy(Policy policy) throws ClassNotFoundException, SQLException;

	   Policy getPolicy(int policyId) throws ClassNotFoundException, SQLException;

	  List<Policy> getAllPolicies() throws ClassNotFoundException, SQLException;
    
	 boolean updatePolicy(Policy policy) throws ClassNotFoundException, SQLException;
 
	 boolean deletePolicy(int policyId) throws ClassNotFoundException, SQLException;
}
