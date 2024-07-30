package com.Bank.App;

import java.util.Scanner;

import com.Bank.DAO.Customer_Dao_IMPL;
import com.Bank.DTO.Customer;

public class SignUp {
	public static void signup() {
		Customer c = new Customer();
		Customer_Dao_IMPL cdao = new Customer_Dao_IMPL();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your name");
		String name = sc.next();
		c.setName(name);
		System.out.println("Enter your Phone number");
		c.setPhone(sc.nextLong());
		System.out.println("Enter your Mail Id ");
		c.setMail(sc.next());
		System.out.println("Set Your pin");
		int pin = sc.nextInt();
		System.out.println("Confirm Your pin");
		int confirm = sc.nextInt();
		if(pin==confirm) {
			c.setPin(pin);
			boolean res = cdao.insertCustomer(c);
			if(res) {
				System.out.println("Data Added Succesfully");
				c=cdao.getCustomer(c.getPhone(), c.getMail());
				System.out.println("Your account number is "+c.getAccno());
			}
			else {
				System.out.println("Failed to create an Account");
			}
		}
		
	}
}
