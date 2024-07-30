package com.Bank.App;

import java.util.Scanner;

import com.Bank.DAO.*;
import com.Bank.DTO.Customer;

public class UpdatePin {
	
	public static void updatepin(Customer c) {
		Customer_DAO cdao = new Customer_Dao_IMPL();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Old Pint");
		int old_pin = sc.nextInt();
		if(old_pin==c.getPin()) {
			System.out.println("Enter the new Pin");
			int newpin=sc.nextInt();
			c.setPin(newpin);
			boolean res = cdao.updateCustomer(c);
			if(res) {
				System.out.println("Your pin "+c.getPin()+" is updated succesfully");
				System.out.println("Your updated Pin is "+c.getPin());
			}
			else {
				System.out.println("Failed to Update! Try again later");
			}
		}
		
	}
}
