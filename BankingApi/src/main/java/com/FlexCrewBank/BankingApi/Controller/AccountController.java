package com.FlexCrewBank.BankingApi.Controller;

import com.FlexCrewBank.BankingApi.Model.Account;
import com.FlexCrewBank.BankingApi.Model.Customer;
import com.FlexCrewBank.BankingApi.Model.Message;
import com.FlexCrewBank.BankingApi.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Optional;


@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    //create an account method
    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public Message createAccountRecord(@RequestBody Account account){
        accountService.createAccount(account);
        HttpHeaders headers = new HttpHeaders();
        URI newAccountURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(account.getId())
                .toUri();
        headers.setLocation(newAccountURI);
        ArrayList arrayList = new ArrayList();
        arrayList.add(accountService.getAnAccount(account.getId()));
        Message message = new Message(HttpStatus.CREATED,"Success", arrayList);
        return message;

    }

    //get all accounts method
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Account>> getAllAccountsRecord(){
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    //get an account by Id method
    @RequestMapping(value = "/accounts/{accountsId}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Account>> getAnAccountRecord(@PathVariable Long accountsId){
        return new ResponseEntity<>(accountService.getAnAccount(accountsId), HttpStatus.OK);
    }

    //get all accounts by id method
    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Account>> getAllAccountsByIdRecord(@PathVariable Iterable<Long> customerId){
        return new ResponseEntity<>(accountService.getAllAccountsByID(customerId), HttpStatus.OK);
    }

    //update an account method
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAnAccountRecord(@RequestBody Account account, @PathVariable Long id){
        accountService.updateAnAccount(account,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //delete an account method
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccountRecord(@PathVariable Long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

