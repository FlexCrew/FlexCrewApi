package com.FlexCrewBank.BankingApi.Service;


import com.FlexCrewBank.BankingApi.Model.Account;
import com.FlexCrewBank.BankingApi.Repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;

    //methods have not been tested


    //create an account method
    public void createAccount(Long customer_id, Account account){
        accountRepo.save(customer_id);
    }

    //get all accounts method
    public Iterable<Account> getAllAccounts(){
        return accountRepo.findAll();
    }

    //get an account by ID method
    public Optional<Account> getAnAccount(Long id){
        return accountRepo.findById(id);
    }

    //get all accounts by ID method
    public Iterable<Account> getAllAccountsByID(Long customer_id, Account account){
        return accountRepo.findAllById(customer_id);
    }

    //delete a specific account method
    public void deleteAccount(Long id){
        accountRepo.deleteById(id);
    }

    //update an account method
    public void updateAnAccount(Account account){
        accountRepo.save(account);
    }

    //exists by ID method
    public Boolean accountExists(Long id){
        return accountRepo.existsById(id);
    }
}

