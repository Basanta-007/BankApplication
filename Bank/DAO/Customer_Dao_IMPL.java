package com.Bank.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.Bank.Connector.Connector;
import com.Bank.DTO.Customer;

public class Customer_Dao_IMPL implements Customer_DAO {
Scanner sc = new Scanner(System.in);

private Connection con;
public Customer_Dao_IMPL(){
	this.con = Connector.requestConnection();
	
}

	@Override
	public boolean insertCustomer(Customer c) {
		PreparedStatement ps = null;
		String query = "INSERT INTO CUSTOMER(NAME,PHONE,MAIL,PIN)VALUES(?,?,?,?)";
		int res =0;
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement(query);
			ps.setString(1, c.getName());
			ps.setLong(2,c.getPhone());
			ps.setString(3,c.getMail());
			ps.setInt(4,c.getPin());
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>0) {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}else {
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
	}

	@Override
	public Customer getCustomer(int pin, long accno) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer c = null;
		String query = "SELECT * FROM CUSTOMER WHERE ACC_NO=? AND PIN =?";
		try {
			ps = con.prepareStatement(query);
			ps.setLong(1, accno);
			ps.setInt(2, pin);
			rs=ps.executeQuery();
			while(rs.next()) {
				c = new Customer();
				c.setAccno(rs.getLong(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setMail(rs.getString(4));
				c.setBal(rs.getDouble(5));
				c.setPin(rs.getInt(6));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Customer getCustomer(long phone, String Mail) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer c = null;
		String query = "SELECT * FROM CUSTOMER WHERE PHONE=? OR MAIL =?";
		try {
			ps = con.prepareStatement(query);
			ps.setLong(1, phone);
			ps.setString(2, Mail);
			rs=ps.executeQuery();
			while(rs.next()) {
				c = new Customer();
				c.setAccno(rs.getLong(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setMail(rs.getString(4));
				c.setBal(rs.getDouble(5));
				c.setPin(rs.getInt(6));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Customer getCustomer(long accno) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer c = null;
		String query = "SELECT * FROM CUSTOMER WHERE ACC_NO=?";
		try {
			ps = con.prepareStatement(query);
			ps.setLong(1, accno);
			rs=ps.executeQuery();
			while(rs.next()) {
				c = new Customer();
				c.setAccno(rs.getLong(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setMail(rs.getString(4));
				c.setBal(rs.getDouble(5));
				c.setPin(rs.getInt(6));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
		
	}

	@Override
	public List getAllCustomerData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		
		PreparedStatement ps = null;
		String query = "UPDATE CUSTOMER SET NAME =?,PHONE = ?,MAIL=?,BALANCE = ?,PIN=? WHERE ACC_NO =?";
		int res =0;
		
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement(query);
//			System.out.println("Enter the money you want to Deposite");
//			double a =sc.nextLong();
////			c.setBal(a);
//			double cur_balance = c.getBal();
//			double new_balance = c.getBal()+a;
//			c.setBal(new_balance);
			
			ps.setString(1, c.getName());
			ps.setLong(2, c.getPhone());
			ps.setString(3, c.getMail());
			ps.setDouble(4, c.getBal());
			ps.setInt(5, c.getPin());
			ps.setLong(6, c.getAccno());
			
//			ps.setDouble(1, new_balance);
//			ps.setDouble(2, c.getAccno());
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>0) {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}else {
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
	}
	@Override
	public boolean deleteCustomer(Customer c) {
		// TODO Auto-generated method stub
		return false;
	}

}
