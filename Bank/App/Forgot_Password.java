package com.Bank.App;

import java.util.Scanner;

import com.Bank.DAO.*;
import com.Bank.DTO.Customer;

public class Forgot_Password {
	
	public static void fotgotPass(Customer c) {
		Customer_DAO cdao = new Customer_Dao_IMPL();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Phone No");
		long a = sc.nextLong();
		System.out.println("Enter your mail");
		String b= sc.next();
		Customer c1 = cdao.getCustomer(a, b);
		System.out.println("Your Old pin is "+c1.getPin());
		
	}
}

