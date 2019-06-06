package com.FlexCrewBank.BankingApi.Controller;

import com.FlexCrewBank.BankingApi.Model.Deposit;
import com.FlexCrewBank.BankingApi.Service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
@RestController
public class DepositController {
    @Autowired
    public DepositService depositService;


    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Deposit>> getAllDeposits(){
        depositService.getAllDeposits();
        return new ResponseEntity<>(depositService.depositRepo.findAll(), HttpStatus.OK);
    }
    @RequestMapping(value = "deposits/{depositId}", method = RequestMethod.GET)
    public ResponseEntity<Deposit> getDepositById(@PathVariable Long id){
        Deposit w = depositService.findById(id);
        return new ResponseEntity<>(w, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.POST)
    public ResponseEntity<?> createDeposit(@RequestBody Deposit deposit){
        depositService.addDeposit(deposit);
        HttpHeaders headers = new HttpHeaders();
        URI newDepositURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(deposit.getId())
                .toUri();
        headers.setLocation(newDepositURI);
        return new ResponseEntity<>(null, headers ,HttpStatus.CREATED);
    }
    @RequestMapping(value = "deposits/{depositId}",method = RequestMethod.PUT)
    public ResponseEntity<?> updateDeposit(@PathVariable Long id, @RequestBody Deposit deposit){
        if (depositService.existsById(id)){
            depositService.addDeposit(deposit);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return createDeposit(deposit);
        }
    }
    @RequestMapping(value = "deposit/{depositId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDeposit(@PathVariable Long id){
        depositService.deleteDeposit(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

