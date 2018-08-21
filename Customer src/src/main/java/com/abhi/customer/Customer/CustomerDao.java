package com.abhi.customer.Customer;

import java.sql.SQLException;

public interface CustomerDao {
	boolean createCustomer(Customer cust) throws SQLException;
	Customer findCustomer(int id) throws SQLException;
	boolean updateCustomer(Customer cust) throws SQLException;
	boolean deleteCustomer(int id) throws SQLException;
}
