package com.cjc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.main.model.Account;
import com.cjc.main.serviceI.HomeService;

@Controller
public class HomeController {

	@Autowired
	HomeService hs;
	
	@RequestMapping("/")
	public String prehome()
	{
		return "home";
	}
	
	@RequestMapping("/register")
	public String reg()
	{
		return "register";
	}

	@RequestMapping("/regData")
	public String register(@ModelAttribute Account a)
	{
		hs.saveData(a);
		
		return "home";
	}
	@RequestMapping("/lg")
	public String prelog()
	{
		return "login";
	}
	
	@RequestMapping("/log")
	public String loginCheck(@RequestParam("uname") String uname, @RequestParam("pass") String pass,Model m)
	{
		Account a=hs.loginCheck(uname,pass);
		Iterable<Account> la=hs.displayAllData();
		m.addAttribute("data", la);
		return "success";
	}
	
	@RequestMapping("/deposit")
	public String depositMoney(@RequestParam("accountno") int accountno, @RequestParam("amount") double amount, Model m) {
	     Account a=hs.depositMoney(accountno, amount);
	     Iterable<Account> la=hs.displayAllData();
			m.addAttribute("data", la);
	    return "success";
	}

	@RequestMapping("/withdraw")
	public String withdrawMoney(@RequestParam("accountno") int accountno, @RequestParam("amount") double amount, Model m) {
	     Account a=hs.withdrawMoney(accountno, amount);
	     Iterable<Account> la=hs.displayAllData();
			m.addAttribute("data", la);
	    return "success";
	}


}
