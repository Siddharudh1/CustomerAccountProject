package Mypackage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import Mypackage.Account;

public class AccountOperation {
	static List<Account> L1 = new ArrayList<Account>();
	public static Account acc=null;
	public static void CreateCustomerAccount(String FirstName,String Username,String LastName,int Age,String Address,String MobileNumber,String EMailID,String Dateofbirth) {
		
		long pin = (long) (Math.random()*10000);
		System.out.println("Pin generated is :"+pin);
		long accNumber = (long)(Math.random()*1000000000);
		System.out.println("Account Number :"+accNumber);
		Account a1 =new Account(FirstName,Username,LastName,Age,Address,MobileNumber,EMailID,Dateofbirth,accNumber,pin);
		System.out.println("Customer Details............");
		System.out.println("FirstName 	 : "+FirstName);
		System.out.println("Username  	 : "+Username);
		System.out.println("LastName  	 : "+LastName);
		System.out.println("Age       	 : "+Age);
		System.out.println("Address   	 : "+Address);
		System.out.println("MobileNumber 	: "+MobileNumber);
		System.out.println("EMailID		 : "+EMailID);
		System.out.println("Dateofbirth  	: "+Dateofbirth);
		L1.add(a1);
	}
	public static void addMoney(String username,double amount) {
		for(Account ele : L1) {
			if(ele.getUsername().equals(username)) {
				double bal = ele.getBalance(); 
				ele.setBalnce(bal+amount); 
				System.out.println("Amount "+amount+" credited Successfully....... ");
			}
		}
		
	}
	
	public static void viewBalance(String username) {
		for(Account ele :L1) {
			if(ele.getUsername().equals(username)) {
				System.out.println("Current balance is : "+ele.getBalance());
			}
		}
	}
	public static void withDrawMoney(String username,double amount) {
		for(Account ele : L1) {
			if(ele.getUsername().equals(username) && amount <= ele.getBalance()) {
				double bal = ele.getBalance();
				ele.setBalnce(bal - amount);
				System.out.println("Amount "+amount+ "withdraw successfully ");
			}
		}
	}
	public static void closeAccount(String userName, long pin) {
		java.util.Iterator<Account> it = L1.iterator();
		
		while (it.hasNext()) {
			Account ele = it.next();
			if(ele.getUsername().equals(userName) && ele.getPin() == pin) {
				it.remove();
			}
		}
		System.out.println("The  account of "+acc.getUsername()+" got successfully deactivated...");	
	}
	
	
}
