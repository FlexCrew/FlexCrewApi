package com.FlexCrewBank.BankingApi.Service;

import com.FlexCrewBank.BankingApi.Model.Customer;
import com.FlexCrewBank.BankingApi.Repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public void createCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public Iterable<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public void updateCustomer(Customer customer, Long id){
        for (int i =0; i < customerRepository.count(); i++){
            if (customerRepository.existsById(id)){
                customerRepository.save(customer);
            }
        }
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

    public Optional<Customer> getCustomer(Long id){
        return customerRepository.findById(id);
    }
}
