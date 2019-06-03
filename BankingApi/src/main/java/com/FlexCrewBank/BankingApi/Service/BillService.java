package com.FlexCrewBank.BankingApi.Service;

import com.FlexCrewBank.BankingApi.Model.Bill;
import com.FlexCrewBank.BankingApi.Repo.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillService {
    @Autowired
    BillRepo billRepo;

    public void createBill(Bill bill) {
        billRepo.save(bill);
    }

    public Optional<Bill> getBill(Long id) {
        return billRepo.findById(id);
    }

    public Iterable<Bill> getAllBillData(){
        return billRepo.findAll();
    }
    public void deleteBill(Long id) {
        billRepo.deleteById(id);
    }
    public void updateBill(Bill bill, Long id){
        for(int i = 0; i< billRepo.count(); i++){
            if(billRepo.existsById(id)){
                billRepo.save(bill);
            }
        }
    }
    public void ExistingBill(Long id){
        billRepo.existsById(id);

    }
}
