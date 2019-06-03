package com.FlexCrewBank.BankingApi.Controller;
import com.FlexCrewBank.BankingApi.Model.Bill;
import com.FlexCrewBank.BankingApi.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
@CrossOrigin("*")
@RestController
public class BillController {


        @Autowired
        private BillService billService;

        @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.GET)
        public ResponseEntity<Iterable<Bill>> getAllBills (){
            Iterable<Bill> allBills = billService.getAllBillData();
            return new ResponseEntity<>(allBills, HttpStatus.OK);

        }

        @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.POST)
        public ResponseEntity<?> createBillData(@RequestBody Bill bill){
            billService.createBill(bill);

            HttpHeaders responseHeader = new HttpHeaders();
            URI newBill= ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(bill.getId())
                    .toUri();
            responseHeader.setLocation(newBill);
            return new ResponseEntity<>(null,responseHeader,HttpStatus.CREATED);
        }

        @RequestMapping(value = "/bills/{billId}", method = RequestMethod.GET)
        public ResponseEntity<?> getBillData (@PathVariable Long billId){
            return new ResponseEntity<>(billService.getBill(billId), HttpStatus.OK);
        }

        @RequestMapping(value = "/bills/{billId}", method = RequestMethod.PUT)
        public ResponseEntity<?> updateBill (@RequestBody Bill bill, @PathVariable Long billId ){
            billService.updateBill(bill, billId);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @RequestMapping(value = "/bills/{billId}",method = RequestMethod.DELETE)
        public ResponseEntity<?> deleteBill (@PathVariable Long billId){
            billService.deleteBill(billId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }



