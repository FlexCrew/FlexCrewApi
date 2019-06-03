package com.FlexCrewBank.BankingApi.Controller;

import com.FlexCrewBank.BankingApi.Model.Account;
import com.FlexCrewBank.BankingApi.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    //create an account method
    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public ResponseEntity<?> createAccountRecord(@RequestBody Long customer_id){
        accountService.createAccount(customer_id);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    //get all accounts method
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Account>> getAllAccountsRecord(){
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    //get an account by Id method
    @RequestMapping(value = "/accounts/{accountsId}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Account>> getAnAccountRecord(@PathVariable Long id){
        return new ResponseEntity<>(accountService.getAnAccount(id), HttpStatus.OK);
    }

    //get all accounts by id method
    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.GET)
    public ResponseEntity<Account> getAllAccountsByIdRecord(@PathVariable Long customer_id){
        return new ResponseEntity<>(accountService.getAllAccountsByID(customer_id), HttpStatus.OK);
    }

    //update an account method
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAnAccountRecord(@RequestBody Account account){
        accountService.updateAnAccount(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //delete an account method
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccountRecord(@PathVariable Long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

