package com.Bank.App;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import com.Bank.Connector.Connector;
import com.Bank.DTO.Customer;

public class Passbook {
	
	private Connection con;
	public Passbook(){
		this.con = Connector.requestConnection();
		
	}
	
	public static long rand() {
		Random r = new Random();
		int random =79393947+r.nextInt(98347863);
		return random;
	}
	
	public void credited(long receiver,double amount,Customer c) {
		LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = today.format(formatter);
		PreparedStatement ps = null;
		String query = "INSERT INTO PASSBOOK(TRAN_ID,USER_ACC,TRAN_DATE,TRAN_TYPE,AMOUNT,BALANCE)VALUES(?,?,?,'CREDITED',?,?)";
		int res =0;
		try {
			long tid=rand();

			ps=con.prepareStatement(query);
			ps.setLong(1, tid);
			ps.setLong(2,receiver);
			ps.setString(3, formattedDate);
			ps.setDouble(4, amount);
			ps.setDouble(5, c.getBal());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void debited(long sender,double amount,Customer c) {
		LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = today.format(formatter);
		PreparedStatement ps = null;
		String query = "INSERT INTO PASSBOOK(TRAN_ID,USER_ACC,TRAN_DATE,TRAN_TYPE,AMOUNT,BALANCE)VALUES(?,?,?,'DEBITED',?,?)";
		int res =0;
		try {
			long tid=rand();
		
			ps=con.prepareStatement(query);
			ps.setLong(1, tid);
			ps.setLong(2,sender);
			ps.setString(3, formattedDate);
			ps.setDouble(4, amount);
			ps.setDouble(5, c.getBal());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void display(long acc) {
		PreparedStatement ps = null;
		String query = "SELECT * FROM PASSBOOK WHERE USER_ACC = '"+acc+"'";
		try {
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			System.out.println("---------------Passbook--------------");
			while(rs.next()) {
				System.out.println("Transaction Id : "+rs.getString(2));
				System.out.println("User Account : "+rs.getString(3));
				System.out.println("Transaction Date : "+rs.getString(4));
				System.out.println("Transaction Type : "+rs.getString(5));
				System.out.println("Transaction Amount : "+rs.getString(6));
				System.out.println("Current Balance : "+rs.getString(7));
				System.out.println("----------------------------------------------");
				System.out.println("----------------------------------------------");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
