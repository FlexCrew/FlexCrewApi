package com.FlexCrewBank.BankingApi.Repo;

import com.FlexCrewBank.BankingApi.Model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DepositRepo extends CrudRepository<Deposit, Long> {

}
