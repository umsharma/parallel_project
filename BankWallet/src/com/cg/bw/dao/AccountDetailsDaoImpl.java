package com.cg.bw.dao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import com.cg.bw.dto.AccountDetails;
import com.cg.bw.dto.CustDetails;
import com.cg.bw.util.DBUtil;



public class AccountDetailsDaoImpl implements AccountDetailsDao {
	static Random rand = new Random();

	@Override
	public CustDetails signIn(String cstId, String cstPass) {
		// TODO Auto-generated method stub
		AccountDetails credential = null;
		CustDetails customer = null;
		HashMap<String, String> credDBMap = DBUtil.getAllCustCred();
		HashMap<String, CustDetails> bankDBMap = DBUtil.getAllCustomer();
		Iterator<String> itKey = credDBMap.keySet().iterator();
		Iterator<String> itPass = credDBMap.values().iterator();
		Iterator<CustDetails> it = bankDBMap.values().iterator();
		while (itKey.hasNext()) {
			credential = new AccountDetails(itKey.next(), itPass.next());
			customer = it.next();
			if (credential.getAccNumber().equals(cstId)
					&& credential.getPassword().equals(cstPass)) {
				return customer;
			}
		}
		return null;
	}

	@Override
	public void deposit(int depositAmount, CustDetails customer) {
		// TODO Auto-generated method stub
		customer.setBalance(customer.getBalance() + depositAmount);

	}

	@Override
	public void withdraw(int withdrawAmount, CustDetails customer) {
		// TODO Auto-generated method stub
		customer.setBalance(customer.getBalance() - withdrawAmount);

	}

	@Override
	public CustDetails transfer(int transferAmount, CustDetails customer,
			String reciever) {
		// TODO Auto-generated method stub
		CustDetails transReciever = null;
		HashMap<String, CustDetails> bankDBMap = DBUtil.getAllCustomer();
		Iterator<CustDetails> it = bankDBMap.values().iterator();
		while (it.hasNext()) {
			transReciever = it.next();
			if (transReciever.getAccNumber().equals(reciever)) {
				return transReciever;
			}
		}
		return transReciever;
	}

	@Override
	public String createAccount(String password, String custName, String accType) {
		// TODO Auto-generated method stub
		return DBUtil.newCustomer(password,
				new CustDetails(Integer.toString(rand.nextInt(50) + 1), custName,
						LocalDate.now(), accType, 0.0F, 200000.0));
	}
}
