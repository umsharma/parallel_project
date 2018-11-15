package com.cg.bw.util;



import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.cg.bw.dto.CustDetails;



public class DBUtil {
	static Random rand = new Random();
	public static HashMap<String, CustDetails> bankDBMap = new HashMap<>();
	public static HashMap<String, String> AccountDetailsDBMap = new HashMap<>();
	static {
		AccountDetailsDBMap.put("162221", "ay123");
		bankDBMap.put(
				"162221",
				new CustDetails("162221", "Umesh Sharma", LocalDate.of(1996,
						Month.MAY, 24), "Saving", 15500.0F, 200000.0));
		AccountDetailsDBMap.put("160662", "di123");
		bankDBMap.put("160662", new CustDetails("160662", "Daya Nandi",
				LocalDate.of(2018, Month.SEPTEMBER, 26), "Current", 15500.0F,
				200000.0));
		AccountDetailsDBMap.put("160601", "ab123");
		bankDBMap.put("160601", new CustDetails("160601", "Abhimanu Sharma",
				LocalDate.of(2018, Month.SEPTEMBER, 14), "Saving", 15500.0F,
				200000.0));
		AccountDetailsDBMap.put("160608", "ra123");
		bankDBMap.put(
				"160608",
				new CustDetails("160608", "Ravi Tandon", LocalDate.of(2017,
						Month.DECEMBER, 15), "Current", 15500.0F, 200000.0));
	}

	public static String newCustomer(String password, CustDetails customer) {
	AccountDetailsDBMap.put(customer.getAccNumber(), password);
		bankDBMap.put(customer.getAccNumber(), customer);
		return customer.getAccNumber();
	}

	public static HashMap<String, String> getAllCustCred() {
		return AccountDetailsDBMap;
	}

	public static HashMap<String, CustDetails> getAllCustomer() {
		return bankDBMap;
	}

}
