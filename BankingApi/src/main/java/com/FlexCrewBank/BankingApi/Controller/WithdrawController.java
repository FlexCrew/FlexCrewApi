package com.FlexCrewBank.BankingApi.Controller;

import com.FlexCrewBank.BankingApi.Model.Withdraw;
import com.FlexCrewBank.BankingApi.Service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin("http://localhost:4200")
public class WithdrawController {

    @Autowired
    public WithdrawService withdrawService;


    @RequestMapping(value = "/accounts/{accountId}withdrawals", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Withdraw>> getAllWithdrawals(){
        withdrawService.getAllWithdraws();
        return new ResponseEntity<>(withdrawService.withdrawRepo.findAll(), HttpStatus.OK);
    }
    @RequestMapping(value = "withdrawals/{withdrawallId}", method = RequestMethod.GET)
    public ResponseEntity<Withdraw> getWithdrawlById(@PathVariable Long id){
        Withdraw w = withdrawService.findById(id);
        return new ResponseEntity<>(w, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}/withdrawals", method = RequestMethod.POST)
    public ResponseEntity<?> createWithdraw(@RequestBody Withdraw withdraw){
        withdrawService.addWithdraw(withdraw);
        HttpHeaders headers = new HttpHeaders();
        URI newWithdrawURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(withdraw.getId())
                .toUri();
        headers.setLocation(newWithdrawURI);
        return new ResponseEntity<>(null, headers ,HttpStatus.CREATED);
    }
    @RequestMapping(value = "withdrawals/{withdrawallId}",method = RequestMethod.PUT)
    public ResponseEntity<?> updateWithdrawal(@PathVariable Long id, @RequestBody Withdraw withdraw){
        if (withdrawService.existsById(id)){
            withdrawService.addWithdraw(withdraw);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return createWithdraw(withdraw);
        }
    }
    @RequestMapping(value = "withdrawals/{withdrawallId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePerson(@PathVariable Long id){
        withdrawService.deleteWithdraw(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
