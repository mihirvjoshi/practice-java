package com.practice.java.design.patterns.chainofresponsibility;

public class TradeAccount {

	double accountNumber;
	
	String accountHolder;
	
	double beneficiaryAccountNumber;
	
	String beneficiaryAddress;
	
	double tradedAmount;
	
	TradeType tradeType;

	public TradeAccount(double accountNumber, String accountHolder,
			double beneficiaryAccountNumber, String beneficiaryAddress,
			double tradedAmount) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
		this.beneficiaryAddress = beneficiaryAddress;
		this.tradedAmount = tradedAmount;
	}
	
	
	public TradeAccount(TradeType tradeType) {
		this.tradeType = tradeType;
	}


	public TradeAccount() {	System.out.println("Trade Account Created");}

	public double getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public double getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}

	public void setBeneficiaryAccountNumber(double beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	public String getBeneficiaryAddress() {
		return beneficiaryAddress;
	}

	public void setBeneficiaryAddress(String beneficiaryAddress) {
		this.beneficiaryAddress = beneficiaryAddress;
	}

	public double getTradedAmount() {
		return tradedAmount;
	}

	public void setTradedAmount(double tradedAmount) {
		this.tradedAmount = tradedAmount;
	}
	
	public TradeType getTradeType() {
		return tradeType;
	}

	public void setTradeType(TradeType tradeType) {
		this.tradeType = tradeType;
	}

	
}
