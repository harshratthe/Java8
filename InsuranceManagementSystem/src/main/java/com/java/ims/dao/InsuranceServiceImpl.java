package com.java.ims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.ims.entity.Policy;
import com.java.ims.util.ConnectionHelper;

public class InsuranceServiceImpl implements IPolicyService {

	@Override
	public boolean createPolicy(Policy policy) throws ClassNotFoundException, SQLException {
        String cmd = "INSERT INTO Policy (policyName, policyType, coverageAmount, premiumAmount) VALUES (?, ?, ?, ?)";
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement ps = conn.prepareStatement(cmd);
        ps.setString(1, policy.getPolicyName());
        ps.setString(2, policy.getPolicyType());
        ps.setDouble(3, policy.getCoverageAmount());
        ps.setDouble(4, policy.getPremiumAmount());

        int rows = ps.executeUpdate();
        return rows > 0;

           }

	

	@Override
	public Policy getPolicy(int policyId) throws ClassNotFoundException, SQLException {
		String cmd = "SELECT * FROM Policy WHERE policyId = ?";
		Connection conn = ConnectionHelper.getConnection();
		  PreparedStatement ps = conn.prepareStatement(cmd);
		  ps.setInt(1, policyId);
          ResultSet rs = ps.executeQuery();
          if (rs.next()) {
              return new Policy(
                  rs.getInt("policyId"),
                  rs.getString("policyName"),
                  rs.getString("policyType"),
                  rs.getDouble("coverageAmount"),
                  rs.getDouble("premiumAmount")
              );
          }

          return null;
		  
	}

	@Override
	public List<Policy> getAllPolicies() throws ClassNotFoundException, SQLException {
		List<Policy> policies = new ArrayList<>();
        String cmd = "SELECT * FROM Policy";

        Connection conn = ConnectionHelper.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(cmd);

        while (rs.next()) {
            Policy policy = new Policy(
                rs.getInt("policyId"),
                rs.getString("policyName"),
                rs.getString("policyType"),
                rs.getDouble("coverageAmount"),
                rs.getDouble("premiumAmount")
            );
            policies.add(policy);
        }

        return policies;
	}

	@Override
	public boolean updatePolicy(Policy policy) throws ClassNotFoundException, SQLException {
		String cmd = "UPDATE Policy SET policyName = ?, policyType = ?, coverageAmount = ?, premiumAmount = ? WHERE policyId = ?";
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement ps = conn.prepareStatement(cmd);

        ps.setString(1, policy.getPolicyName());
        ps.setString(2, policy.getPolicyType());
        ps.setDouble(3, policy.getCoverageAmount());
        ps.setDouble(4, policy.getPremiumAmount());
        ps.setInt(5, policy.getPolicyId());

        int rows = ps.executeUpdate();
        return rows > 0;
	}

	@Override
	public boolean deletePolicy(int policyId) throws ClassNotFoundException, SQLException {
		String cmd = "DELETE FROM Policy WHERE policyId = ?";
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement ps = conn.prepareStatement(cmd);

        ps.setInt(1, policyId);
        int rows = ps.executeUpdate();

        return rows > 0;
	}

}
