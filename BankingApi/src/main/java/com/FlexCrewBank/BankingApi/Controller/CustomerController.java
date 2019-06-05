package com.FlexCrewBank.BankingApi.Controller;

import com.FlexCrewBank.BankingApi.Model.Customer;
import com.FlexCrewBank.BankingApi.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomerAccount(@RequestBody Customer customer){
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(customer.getId())
                .toUri();
        responseHeaders.setLocation(newCustomerUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/ customers", method = RequestMethod.GET)
    public List<Customer> getAllCustomerAccounts(){
        return customerService.getAllCustomers();
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
    public void updateCustomerAccount(@RequestBody Customer customer, @PathVariable Long id){
        customerService.updateCustomer(customer);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public void deleteCustomerAccount(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }
    @RequestMapping(value = "student/{id}", method = RequestMethod.GET)
    public Optional<Customer> getOneCustomerAccount(@PathVariable Long id){
        return customerService.getCustomer(id);
    }
}
