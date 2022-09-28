package br.com.dio;

public class Account implements AccountInterface {


	private String accountNumber;
	private String agency;
	private double balance;
	
	//The data is stored in a .txt file, no BD is used.The passawword is any word
	protected Customer customer;

	public Account(Customer customer) {
		
		this.accountNumber = customer.getAccountNumber();
		this.agency = customer.getAgency();
		this.balance = customer.getBalance();
	}

	public Account() {
		
		this.agency = "";
		this.accountNumber = "";
		this.balance = 0.0;
	}
	
	public double withdraw(double value) {
		balance -= value;
		return balance;
	}

	
	public double deposit(double value) {
		balance += value;
		return balance;
	}

	
	/*public double transfer(double value) {
		this.withdraw(value);
	}*/

	public String getAgency() {
		return agency;
	}

	public String getNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
