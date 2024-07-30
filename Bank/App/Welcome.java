package com.Bank.App;

import java.util.Scanner;
import com.Bank.App.*;

public class Welcome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("<----------Welcome to New Bank----------->");
		int ch=0;
				do {
					
					System.out.println("1: Customer Login");
					System.out.println("2: Create an Account");
					System.out.println("3: Exit");
					ch = sc.nextInt();
					switch(ch) {
					case 1:
						LogIn.login();
						break;
					case 2:
						SignUp.signup();
						break;
					case 3:
						System.out.println("Exititng the Application");
						break;
					default:
						System.out.println("Invalid input.Please try again");
					}	
				
				}while(ch!=3);
	}

}
