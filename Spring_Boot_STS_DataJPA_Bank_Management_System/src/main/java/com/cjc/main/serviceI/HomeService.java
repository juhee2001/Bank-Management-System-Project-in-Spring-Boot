package com.cjc.main.serviceI;

import com.cjc.main.model.Account;

public interface HomeService {

	public void saveData(Account a);

	public Account loginCheck(String uname, String pass);

	public Iterable<Account> displayAllData();

	public Account depositMoney(int accountno, double amount);

	public Account withdrawMoney(int accountno, double amount);

  
}
