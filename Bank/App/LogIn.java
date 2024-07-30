package com.Bank.App;

import java.util.Scanner;

import com.Bank.DAO.Customer_Dao_IMPL;
import com.Bank.DTO.Customer;

public class LogIn {
	public static void login() {
		Scanner sc = new Scanner(System.in);
		Customer_Dao_IMPL cdao = new Customer_Dao_IMPL();
		System.out.println("Enter your Account number");
		long accno = sc.nextLong();
		System.out.println("Enter your pin");
		int pin = sc.nextInt();
		Customer c = cdao.getCustomer(pin, accno);
		if(c!=null) {
			System.out.println("Login Successfull");
			App.option(c, accno);
			
		}else {
			System.out.println("Failed to login");
			System.out.println("Are You forgot Password Yes or No");
			String s = sc.next();
			if(s.equalsIgnoreCase(s)) {
				Forgot_Password.fotgotPass(c);
			}
			
		}
	}
}
