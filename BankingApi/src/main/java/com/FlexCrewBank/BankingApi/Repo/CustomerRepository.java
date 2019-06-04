package com.FlexCrewBank.BankingApi.Repo;

import com.FlexCrewBank.BankingApi.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
