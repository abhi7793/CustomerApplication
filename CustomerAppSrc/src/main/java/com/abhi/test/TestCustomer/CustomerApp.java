package com.abhi.test.TestCustomer;

import java.sql.SQLException;
import java.util.Scanner;

import com.abhi.customer.Customer.Customer;
import com.abhi.customer.Customer.CustomerDao;
import com.abhi.customer.Customer.CustomerDaoImpl;

public class CustomerApp {
	
	static Scanner scanner= new Scanner(System.in);
	static CustomerDao dao=  new CustomerDaoImpl();
	

	public static void main(String[] args) throws SQLException {
		
		int choice;
		do {
		System.out.println("\n 1.Create new customer object\n 2.Find a customer\n 3.Update customer details\n 4.Delete customer details ");
		System.out.println("enter your choice");
		choice= scanner.nextInt();
		
		
		switch(choice) {
		
		case 1: create();
		break;
		
		case 2: find();
		break;
		
		case 3: update();
		break;
		
		case 4: delete();
		break;
		
		default: choice =5;
		}
		
		}while(!(choice>=5));
		
	}

	private static void delete() throws SQLException {
		System.out.println("Enter id");
		int id = scanner.nextInt();

		boolean flag = dao.deleteCustomer(id);
		if (flag) {
			System.out.println("Deleted successfully");
		} else {
			System.out.println("Failed to delete");
		}
		
	}

	private static void update() throws SQLException {
		Customer cust = readCustomer();
		boolean flag = dao.updateCustomer(cust);
		if (flag) {
			System.out.println("updated successfully");
		} else {
			System.out.println("Failed to update");
		}
		
	}

	private static void create() throws SQLException {
		
		Customer cust = readCustomer();
		boolean flag = dao.createCustomer(cust);
		if (flag) {
			System.out.println("updated successfully");
		} else {
			System.out.println("Failed to update");
		}
		
	}
	
	private static void find() throws SQLException {
		System.out.println("Enter id");
		int id = scanner.nextInt();

		Customer cust = dao.findCustomer(id);
		System.out.println(cust);
		
		
}
	
	
	private static Customer readCustomer() {
		
		System.out.println("Enter id");
		int id = Integer.parseInt(scanner.next());

		System.out.println("Enter name");
		String name = scanner.next();
		
		System.out.println("Enter phone");
		int phone = Integer.parseInt(scanner.next());
		
		System.out.println("Enter address");
		String address = scanner.next();			

		System.out.println("Enter credit score");
		float score = scanner.nextFloat();

		return new Customer(id, name, phone,address, score);
	}
}
