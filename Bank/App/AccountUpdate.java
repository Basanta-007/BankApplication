package com.Bank.App;

import java.util.Scanner;

import com.Bank.DAO.Customer_DAO;
import com.Bank.DAO.Customer_Dao_IMPL;
import com.Bank.DTO.Customer;

public class AccountUpdate {
	
	public static void Update_Acc(Customer c){
		System.out.println("What do you want to update ?");
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			System.out.println("1.Nmae");
			System.out.println("2.Phone");
			System.out.println("3.Mail");
			System.out.println("4.Exit");
			ch = sc.nextInt();
			sc.nextLine();
			switch(ch) {
			case 1:
				System.out.println("Enter Your new name");
				String name = sc.nextLine();
				c.setName(name);
				break;
			case 2:
				System.out.println("Enter Your new Phone");
				long phone = sc.nextLong();
				sc.nextLine();
				c.setPhone(phone);
				break;
			case 3:
				System.out.println("Enter Your new Mail");
				String mail = sc.nextLine();
				c.setMail(mail);
				break;
			case 4:
				ch=4;
				break;
			}
			
		}while(ch!=4);
		Customer_DAO cdao = new Customer_Dao_IMPL();
		boolean res = cdao.updateCustomer(c);
		if(res) {
			System.out.println("Your Account is Updated");
		}else {
			System.out.println("Your Account is not updated");
		}
	}
	
}
