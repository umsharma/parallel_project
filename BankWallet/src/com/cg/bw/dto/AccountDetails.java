package com.cg.bw.dto;

public class AccountDetails implements Comparable<AccountDetails> {
	private String accNumber;
	private String password;

	public AccountDetails(String accNumber, String password) {
		super();
		this.accNumber = accNumber;
		this.password = password;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Credentials [accNumber=" + accNumber + ", password=" + password
				+ "]";
	}

	@Override
	public int hashCode() {
		return Integer.parseInt(accNumber);
	}

	@Override
	public boolean equals(Object obj) {
		AccountDetails cred = (AccountDetails) obj;
		if (cred.accNumber.equals(this.accNumber)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(AccountDetails cred) {
		if (Integer.parseInt(cred.accNumber) < Integer.parseInt(this.accNumber)) {
			return -1;
		} else if (cred.accNumber.equals(this.accNumber)) {
			return 0;
		} else {
			return +1;
		}

	}
}
