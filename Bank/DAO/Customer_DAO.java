package com.Bank.DAO;

import java.util.List;

import com.Bank.DTO.Customer;

public interface Customer_DAO {
	boolean insertCustomer(Customer c);
	Customer getCustomer(int pin, long accno);
	Customer getCustomer(long phone,String Mail);
	Customer getCustomer(long accno);
	List getAllCustomerData();
	boolean updateCustomer(Customer c);
	boolean deleteCustomer(Customer c);
	
}
