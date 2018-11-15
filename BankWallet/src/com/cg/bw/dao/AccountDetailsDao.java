package com.cg.bw.dao;

import com.cg.bw.dto.CustDetails;

public interface AccountDetailsDao {

	public CustDetails signIn(String cstId, String cstPass);

	public void deposit(int depositAmount, CustDetails customer);

	public void withdraw(int withdrawAmount, CustDetails customer);

	public CustDetails transfer(int transferAmount, CustDetails customer, String reciever);

	public String createAccount(String password, String custName,
			String accType);

}
