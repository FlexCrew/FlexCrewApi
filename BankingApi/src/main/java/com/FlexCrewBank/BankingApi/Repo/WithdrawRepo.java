package com.FlexCrewBank.BankingApi.Repo;

import com.FlexCrewBank.BankingApi.Model.Withdraw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface WithdrawRepo extends CrudRepository<Withdraw, Long> {
}
