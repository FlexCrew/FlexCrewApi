package com.FlexCrewBank.BankingApi.Service;

import com.FlexCrewBank.BankingApi.Model.Withdraw;
import com.FlexCrewBank.BankingApi.Repo.WithdrawRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class WithdrawService {

    @Autowired
    public WithdrawRepo withdrawRepo;

    public ArrayList<Iterable<Withdraw>> getAllWithdraws(){
        ArrayList<Iterable<Withdraw>> arrayList = new ArrayList<>();
        for (int i =0; i < withdrawRepo.count(); i++){
            arrayList.add(withdrawRepo.findAll());
        }
        return arrayList;
    }
    public boolean existsById(Long id){
        return withdrawRepo.existsById(id);
    }

    public Optional<Withdraw> findById(Long id){
        return withdrawRepo.findById(id);
    }
    public void addWithdraw(Withdraw withdraw){
        withdrawRepo.save(withdraw);
    }
    public void deleteWithdraw(Long id){
        withdrawRepo.deleteById(id);
    }
    public void updateWithdraw(Withdraw withdraw, Long id){
        for (int i =0; i< withdrawRepo.count(); i++){
            if (withdrawRepo.existsById(id)){
                withdrawRepo.save(withdraw);
            }
        }
    }
}
