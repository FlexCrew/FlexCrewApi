package com.FlexCrewBank.BankingApi.Service;

import com.FlexCrewBank.BankingApi.Model.Deposit;
import com.FlexCrewBank.BankingApi.Repo.DepositRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepositService {

    @Autowired
    public DepositRepo depositRepo;


    public ArrayList<Iterable<Deposit>> getAllDeposits(){
        ArrayList<Iterable<Deposit>> depositList = new ArrayList<>();
        for (int i =0; i < depositRepo.count(); i++){
            depositList.add(depositRepo.findAll());
        }
        return depositList;
    }
    public boolean existsById(Long id){
        return depositRepo.existsById(id);
    }
    public Deposit findById(Long id){
        return depositRepo.findById(id).orElse(null);
    }
    public void deleteDeposit(Long id){
        depositRepo.deleteById(id);
    }

    public void addDeposit(Deposit deposit){
        depositRepo.save(deposit);
    }
    public void updateDeposit(Deposit deposit, Long id){
        for (int i =0; i< depositRepo.count(); i++){
            if (depositRepo.existsById(id)){
                depositRepo.save(deposit);
            }
        }
    }

}
