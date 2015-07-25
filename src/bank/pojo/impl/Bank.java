package bank.pojo.impl;

/**
 * Bank entity. @author MyEclipse Persistence Tools
 */

public class Bank implements java.io.Serializable {

	// Fields

	private Integer id;
	private String account;
	private String password;
	private Double balance;

	// Constructors

	/** default constructor */
	public Bank() {
	}

	/** full constructor */
	public Bank(String account, String password, Double balance) {
		this.account = account;
		this.password = password;
		this.balance = balance;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}