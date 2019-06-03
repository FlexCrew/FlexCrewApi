package com.FlexCrewBank.BankingApi.Repo;

import com.FlexCrewBank.BankingApi.Model.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillRepo extends CrudRepository<Bill,Long> {
}
