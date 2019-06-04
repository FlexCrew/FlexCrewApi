package com.FlexCrewBank.BankingApi.Controller;

import antlr.debug.MessageAdapter;
import com.FlexCrewBank.BankingApi.Exception.MessageException;
import com.FlexCrewBank.BankingApi.Model.Customer;
import com.FlexCrewBank.BankingApi.Model.Message;
import com.FlexCrewBank.BankingApi.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

//    public Message validate(Function function, Integer code1, Integer code2, ){}

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public Message createCustomerAccount(@RequestBody Customer customer){
        try {
            customerService.createCustomer(customer);
            ArrayList arrayList = new ArrayList();
            arrayList.add(customerService.getCustomer(customer.getId()));
            Message message = new Message(200, "Success", arrayList);
            return message;
        } catch( Exception e){
            Message message = new Message(404, "Error");
            return message;
        }

//        customerService.createCustomer(customer);
//        Optional<Customer> target_account = customerService.getCustomer(customer.getId());
//        if(!target_account.isPresent())
//            throw new MessageException(HttpStatus.NOT_FOUND, "Error Creating account");
//        if(target_account.isPresent())
//            throw new MessageException(HttpStatus.CREATED, "Success creating account!");
//        return target_account;
//        HttpHeaders headers = new HttpHeaders();
//        URI newDepositURI = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("{id}")
//                .buildAndExpand(customer.getId())
//                .toUri();
//        headers.setLocation(newDepositURI);

    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public Message getAllCustomerAccounts(){
        try {

            ArrayList<Iterable>  arrayList = new ArrayList();
              arrayList.add(customerService.getAllCustomers());
            Message message = new Message(200,"Success", arrayList);
            return message;
        } catch (Exception e){
            Message message = new Message(404, "Error Getting Accounts");
            return message;
        }

    }


    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
    public Message updateCustomerAccount(@RequestBody Customer customer, @PathVariable Long id){
        try{
            customerService.updateCustomer(customer, id);
            ArrayList arrayList = new ArrayList();
            arrayList.add(customerService.getCustomer(customer.getId()));
            Message message = new Message(200, "Updated Customer account with id: " + id, arrayList);
            return message;
        } catch(Exception e){
            Message message = new Message(404, "Error Updating customer with id: " + id);
            return message;
        }
    }

//    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
//    public void deleteCustomerAccount(@PathVariable Long id){
//        customerService.deleteCustomer(id);
//    }
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public Message getOneCustomerAccount(@PathVariable Long id){
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(customerService.getCustomer(id));
            Message message = new Message(200,"Got account with id: " + id, arrayList );
            return message;
        } catch(Exception e){
            Message message = new Message(404, "Error updating account");
            return message;
        }
    }
}
