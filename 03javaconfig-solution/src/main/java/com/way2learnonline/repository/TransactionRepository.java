package com.way2learnonline.repository;

import java.sql.SQLException;
import java.util.List;

import com.way2learnonline.model.TransactionDetail;



public interface TransactionRepository {

	public Long addTransaction(TransactionDetail transactionDetail) throws SQLException;
	public List<TransactionDetail> getAllTransactionDetailsByAccountNumber(Long accountNumber) throws SQLException;
}
