package com.Bank.DTO;

public class Transfer {

	private long tid;
	private int amount;
	private String ttype;
	private String tdate;

	
	public long getTid() {
		return tid;
	}
	public void setTid(long tid) {
		this.tid = tid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getTtype() {
		return ttype;
	}
	public void setTtype(String ttype) {
		this.ttype = ttype;
	}
	public String getTdate() {
		return tdate;
	}
	public void setTdate(String tdate) {
		this.tdate = tdate;
	}
	public double getCbal(Customer cbal) {
		return cbal.getBal();
	}
	
	
	
}
