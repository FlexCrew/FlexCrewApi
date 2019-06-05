package com.FlexCrewBank.BankingApi.Controller;

import com.FlexCrewBank.BankingApi.Model.Message;
import com.FlexCrewBank.BankingApi.Model.Withdraw;
import com.FlexCrewBank.BankingApi.Service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;

@RestController
@CrossOrigin("http://localhost:4200")
public class WithdrawController {

    @Autowired
    public WithdrawService withdrawService;


    @RequestMapping(value = "/accounts/{accountId}withdrawals", method = RequestMethod.GET)
    public Message getAllWithdrawals(){
        try {
            ArrayList arrayList = withdrawService.getAllWithdraws();
            Message message = new Message(HttpStatus.OK,"Success getting Withdrawls", arrayList);
            return message;
        } catch (Exception e){
            Message message = new Message(HttpStatus.NOT_FOUND, "Error");
            return message;
        }
    }
    @RequestMapping(value = "withdrawals/{withdrawallId}", method = RequestMethod.GET)
    public Message getWithdrawlById(@PathVariable Long id){
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(withdrawService.findById(id));
            Message message = new Message(HttpStatus.OK, "Success getting id: " +id, arrayList);
            return message;
        } catch (Exception e){
            Message message = new Message(HttpStatus.NOT_FOUND, "Error getting id: " +id);
            return message;
        }
    }

    @RequestMapping(value = "/accounts/{accountId}/withdrawals", method = RequestMethod.POST)
    public Message createWithdraw(@RequestBody Withdraw withdraw){
        try {
            withdrawService.addWithdraw(withdraw);
            ArrayList arrayList = new ArrayList();
            arrayList.add(withdrawService.findById(withdraw.getId()));
            Message message = new Message(HttpStatus.CREATED,"Created withdraw",arrayList);
            return message;
        } catch (Exception e){
            Message message = new Message(HttpStatus.NOT_FOUND, "Error Creating withdraw");
            return message;
        }
//        HttpHeaders headers = new HttpHeaders();
//        URI newWithdrawURI = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("{id}")
//                .buildAndExpand(withdraw.getId())
//                .toUri();
//        headers.setLocation(newWithdrawURI);
    }
    @RequestMapping(value = "withdrawals/{withdrawallId}",method = RequestMethod.PUT)
    public Message updateWithdrawal(@PathVariable Long id, @RequestBody Withdraw withdraw){
      try{
          withdrawService.updateWithdraw(withdraw, id);
          ArrayList arrayList = new ArrayList();
          arrayList.add(withdrawService.findById(id));
          Message message = new Message(HttpStatus.OK,"Updated id: " +id +" Sucessfully",arrayList);
          return message;
      } catch(Exception e){
          Message message = new Message(HttpStatus.NOT_FOUND,"Error");
          return message;
      }
    }
    @RequestMapping(value = "withdrawals/{withdrawallId}", method = RequestMethod.DELETE)
    public Message deletePerson(@PathVariable Long id){
        try{
            withdrawService.deleteWithdraw(id);
            Message message = new Message(HttpStatus.NO_CONTENT, "Deleted");
            return message;
        } catch (Exception e){
            Message message = new Message(HttpStatus.NOT_FOUND, "This id does not exist");
            return message;
        }
    }
}
