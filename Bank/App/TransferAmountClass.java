package com.Bank.App;

import java.util.Scanner;
import com.Bank.DAO.Customer_DAO;
import com.Bank.DAO.Customer_Dao_IMPL;
import com.Bank.DTO.Customer;


public class TransferAmountClass {
	
	
	public static void transferAmount(Customer c) {
		Passbook pb = new Passbook();
		Customer_DAO cdao = new Customer_Dao_IMPL();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount to be transferred");
		double amount = sc.nextDouble();
		System.out.println("Enter the benificiary acount number");
		long receiver_accno = sc.nextLong();
		Customer receiver = cdao.getCustomer(receiver_accno);
		if(c.getAccno()!=receiver.getAccno()&&c.getBal()>0&&c.getBal()>=amount&&amount >0) {
			System.out.println("Enter the pin");
			int pin = sc.nextInt();
			if(pin ==c.getPin()) {
				c.setBal(c.getBal()-amount);
				
				boolean c_res = cdao.updateCustomer(c);//amount is getting debited from sender account.
				receiver.setBal(receiver.getBal()+amount);
				
				boolean r_res = cdao.updateCustomer(receiver);//amount is gettig creadited to receiver account.
				if(c_res &&  r_res) {
					System.out.println("Transaction Successful");
					pb.credited(receiver.getAccno(), amount, receiver);
					pb.debited(c.getAccno(), amount, c);
				}
			}
		}else {
			System.out.println("Transaction faild!!! ");
		}
		
		
	}

}
