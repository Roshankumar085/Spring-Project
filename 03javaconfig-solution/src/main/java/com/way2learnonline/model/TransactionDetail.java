package com.way2learnonline.model;

import java.util.Date;

public class TransactionDetail {

	private Long transactionId;
	private Long accountNumber;
	private Date transactionDate;
	private int amount;	
	private TransactionType txType;
	
	
	
	
	public TransactionDetail( Long accountNumber,
			Date transactionDate, int amount, TransactionType type) {
		super();
		
		this.accountNumber = accountNumber;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.txType = type;
	}
	
	public TransactionDetail() {
		
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public TransactionType getTxType() {
		return txType;
	}

	public void setTxType(TransactionType txType) {
		this.txType = txType;
	}
	
	
}
