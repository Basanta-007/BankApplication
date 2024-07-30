package com.Bank.App;

import java.util.Scanner;

import com.Bank.DAO.Customer_Dao_IMPL;
import com.Bank.DTO.*;

public class App {
	public static void option(Customer c, long acc) {
		int ch = 0;
		Customer_Dao_IMPL cdi = new Customer_Dao_IMPL();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome "+c.getName()+",");
		System.out.println("Enter Your choice");
		Passbook ps = new Passbook();
		do {
			
			System.out.println("1. Check Balance");
			System.out.println("2. Deposite");
			System.out.println("3. Transfer the amount");
			System.out.println("4. Passbook");
			System.out.println("5. Update Your Account");
			System.out.println("6. Reset PIN");
			System.out.println("7. Go Back to main Menu");
			ch = sc.nextInt();
			
			switch(ch) {
			case 1:
				System.out.println("Your balance is Rs."+c.getBal());
				break;
			case 2:
				Deposite.deposite(c);
				break;
			case 3:
				TransferAmountClass.transferAmount(c);
				break;
			case 4:
				ps.display(acc);
				break;
			case 5:
				AccountUpdate.Update_Acc(c);
				break;
			case 6:
				UpdatePin.updatepin(c);
				break;
			case 7:
				ch=7;
				break;
			}
			
		}while(ch!=7);
	}
	
}
