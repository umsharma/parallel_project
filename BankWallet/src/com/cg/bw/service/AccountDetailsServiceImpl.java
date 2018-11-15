package com.cg.bw.service;

import java.util.regex.Pattern;

import com.cg.bw.dao.AccountDetailsDao;
import com.cg.bw.dao.AccountDetailsDaoImpl;
import com.cg.bw.dto.CustDetails;
import com.cg.bw.exception.TransactionException;

public class AccountDetailsServiceImpl implements AccountDetailsService {
	AccountDetailsDao AccountDetailsDao = null;

	public AccountDetailsServiceImpl() {
		// TODO Auto-generated constructor stub
		AccountDetailsDao = new AccountDetailsDaoImpl();
	}

	@Override
	public CustDetails signIn(String cstId, String cstPass) {
		// TODO Auto-generated method stub
		return AccountDetailsDao.signIn(cstId, cstPass);
	}

	@Override
	public void deposit(int depositAmount, CustDetails customer) {
		// TODO Auto-generated method stub
		AccountDetailsDao.deposit(depositAmount, customer);

	}

	@Override
	public void withdraw(int withdrawAmount, CustDetails customer) {
		// TODO Auto-generated method stub
		AccountDetailsDao.withdraw(withdrawAmount, customer);

	}

	@Override
	public void transfer(int transferAmount, CustDetails customer, String reciever) {
		// TODO Auto-generated method stub
		CustDetails transReciever = AccountDetailsDao.transfer(transferAmount, customer,
				reciever);
		AccountDetailsDao.withdraw(transferAmount, customer);
		AccountDetailsDao.deposit(transferAmount, transReciever);

	}

	@Override
	public boolean validateWithdraw(String withdrawAmount, CustDetails customer)
			throws TransactionException {
		// TODO Auto-generated method stub
		String amountPattern = "[0-9]*";
		if (Pattern.matches(amountPattern, withdrawAmount)) {
			if (Integer.parseInt(withdrawAmount) <= customer.getBalance()) {
				return true;
			} else {
				throw new TransactionException("Insuficient Balance");
			}
		} else {
			throw new TransactionException("Amount must be in number format");
		}
	}

	@Override
	public boolean validateEnteredAmount(String amount)
			throws TransactionException {
		String amountPattern = "[0-9]*";
		if (Pattern.matches(amountPattern, amount)) {
			return true;
		} else {
			throw new TransactionException("Amount must be in number format");
		}
	}

	@Override
	public boolean validateNumber(String choose) throws TransactionException {
		// TODO Auto-generated method stub
		String chooseNum = "[0-9]*";
		if (Pattern.matches(chooseNum, choose)) {
			return true;
		} else {
			throw new TransactionException(
					"Entered choice must be in number format");
		}
	}

	@Override
	public boolean validateName(String name) throws TransactionException {
		String namePatter = "[A-Z][a-z]+" + " " + "[A-Z][a-z]+";

		if (Pattern.matches(namePatter, name)) {
			return true;
		} else {
			throw new TransactionException(" Invalid input "
					+ " Only Char are  allowed  and should start"
					+ " with Capital ex.    Ayushmaan");
		}
	}

	@Override
	public String createAccount(String password, String custName, String accType) {
		// TODO Auto-generated method stub
		return AccountDetailsDao.createAccount(password, custName, accType);
	}
}
