package br.com.dio;

public class Customer{

	//The data is stored in a .txt file, no BD is used.The passawword is any word
	private String name;
	private String id;
	private String agency;
	private String accountNumber;
	private double balance;
	
	

	public Customer(String name,String id, String agency, String accountNumber, double balance) {
		
		this.name = name;
		this.id = id;
		this.accountNumber = accountNumber;
		this.agency = agency;
		this.balance = balance;		
	}



	public Customer() {
		this.name = "";
		this.id = "";
		this.accountNumber = "";
		this.agency = "";
		this.balance = 0.0;
	}


	
	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAgency() {
		return agency;
	}


	public void setAgency(String agency) {
		this.agency = agency;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
