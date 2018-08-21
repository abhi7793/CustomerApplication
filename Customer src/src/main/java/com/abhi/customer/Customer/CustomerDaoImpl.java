package com.abhi.customer.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImpl implements CustomerDao {

	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root",
				"abhiblue77");
		return connection;
	}

	public boolean createCustomer(Customer cust) throws SQLException {

		try (Connection connection = getConnection()) {
			PreparedStatement ps = connection
					.prepareStatement("insert into customer (id,name,phone,address, creditscore) values (?,?,?, ?, ?)");
			ps.setInt(1, cust.getId());
			ps.setString(2, cust.getName());
			
			ps.setInt(3, cust.getPhone());
			ps.setString(4, cust.getAddress());
			ps.setFloat(5, cust.getCreditscore());

			int noOfRowsUpdated = ps.executeUpdate();
			if (noOfRowsUpdated >= 1)
				return true;
			return false;
		}

	}

	@Override
	public Customer findCustomer(int custid) throws SQLException {

		try (Connection connection = getConnection()) {
			PreparedStatement ps = connection
					.prepareStatement("select id, name, phone, address, creditscore from customer where id = ?");
			ps.setInt(1, custid);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int phone = rs.getInt(3);
				String address = rs.getString(4);
				float creditscore = rs.getFloat(5);

				return new Customer(id, name, phone, address, creditscore);
			}

			return null;
		}
	}

	@Override
	public boolean updateCustomer(Customer cust) throws SQLException {

		try (Connection connection = getConnection()) {
			PreparedStatement ps = connection.prepareStatement(
					"update customer set name = ?,phone=?, address = ?, creditscore = ? where id = ?");
			ps.setString(1, cust.getName());
			ps.setInt(5, cust.getId());
			ps.setInt(2, cust.getPhone());
			ps.setString(3, cust.getAddress());
			ps.setFloat(4, cust.getCreditscore());

			int noOfRowsUpdated = ps.executeUpdate();
			if (noOfRowsUpdated >= 1)
				return true;
			return false;
		}

	}

	@Override
	public boolean deleteCustomer(int id) throws SQLException {
		try (Connection connection = getConnection()) {
			PreparedStatement ps = connection.prepareStatement("delete from customer where id = ?");
			ps.setInt(1, id);

			int noOfRowsUpdated = ps.executeUpdate();
			if (noOfRowsUpdated >= 1)
				return true;
			return false;
		}
	}
}
