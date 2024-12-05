package com.cjc.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.main.model.Account;

@Repository
public interface HomeRepository extends CrudRepository<Account, Integer> {

	public Account findAllByUnameAndPass(String uname, String pass);

	public Account findById(int accountno);
}
