package com.cg.bw.service;

import com.cg.bw.dto.CustDetails;
import com.cg.bw.exception.TransactionException;

public interface AccountDetailsService {
	public CustDetails signIn(String cstId, String cstPass);

	public void deposit(int depositAmount, CustDetails customer);

	public void withdraw(int withdrawAmount, CustDetails customer);

	public void transfer(int transferAmount, CustDetails customer, String reciever);

	public boolean validateWithdraw(String withdrawAmount, CustDetails customer)
			throws TransactionException;

	public boolean validateEnteredAmount(String withdrawAmount)
			throws TransactionException;

	public boolean validateNumber(String choose) throws TransactionException;

	public boolean validateName(String name) throws TransactionException;

	public String createAccount(String password, String custName, String accType);

}
