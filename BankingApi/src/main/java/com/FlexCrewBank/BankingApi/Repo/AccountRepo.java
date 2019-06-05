package com.FlexCrewBank.BankingApi.Repo;


import com.FlexCrewBank.BankingApi.Model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<Account, Long> {

}
