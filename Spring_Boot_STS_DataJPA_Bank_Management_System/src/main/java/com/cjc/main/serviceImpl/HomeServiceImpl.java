package com.cjc.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Account;
import com.cjc.main.repository.HomeRepository;
import com.cjc.main.serviceI.HomeService;

@Service
public class HomeServiceImpl implements HomeService{

	@Autowired
	HomeRepository hr;
	
	@Override
	public void saveData(Account a) {
		
		hr.save(a);
	}

	@Override
	public Account loginCheck(String uname, String pass) {
		
		return hr.findAllByUnameAndPass(uname,pass);
	}

	@Override
	public Iterable<Account> displayAllData() {
		
		return hr.findAll();
	}

	
	@Override
	public Account depositMoney(int accountno, double amount) {
	    
	    Account account = hr.findById(accountno);
	    if (account != null) {
	        
	        account.setBalance(account.getBalance() + amount);
	        
	        hr.save(account);
	    }
	    
	    return account;
	}

	@Override
	public Account withdrawMoney(int accountno, double amount) {
		
		Account account = hr.findById(accountno);
	    if (account != null) {
	        
	        account.setBalance(account.getBalance() - amount);
	        
	        hr.save(account);
	    }
		return account;
	}


	
}
