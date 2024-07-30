package com.Bank.App;

import java.util.Scanner;

import com.Bank.DAO.*;
import com.Bank.DTO.Customer;

public class Deposite {
	
	public static void deposite(Customer c) {
		Customer_DAO cdao = new Customer_Dao_IMPL();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount to be Deposited");
		double amount = sc.nextDouble();
		double update_bal=c.getBal()+amount;
		c.setBal(update_bal);
		boolean res = cdao.updateCustomer(c);
		if(res) {
			System.out.println("Amount of Rs."+amount+" has been added successfully");
			System.out.println("Your updated balance is Rs"+c.getBal());
		}
		else {
			System.out.println("Failed to Deposit! Try again later");
		}
	}
}
