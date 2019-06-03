package com.FlexCrewBank.BankingApi.Repo;

import com.FlexCrewBank.BankingApi.Model.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface BillRepo extends CrudRepository<Bill,Long> {
}
