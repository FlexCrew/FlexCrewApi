package com.FlexCrewBank.BankingApi.Controller;
import com.FlexCrewBank.BankingApi.Model.Bill;
import com.FlexCrewBank.BankingApi.Model.Message;
import com.FlexCrewBank.BankingApi.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.ArrayList;

@CrossOrigin("*")
@RestController
public class BillController {


        @Autowired
        private BillService billService;

        @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.GET)
        public Message getAllBills (){
            try {

                ArrayList<Iterable>  arrayList = new ArrayList();
                arrayList.add(billService.getAllBillData());
                Message message = new Message(HttpStatus.OK,"Success", arrayList);
                return message;
            } catch (Exception e){
                Message message = new Message(HttpStatus.NOT_FOUND, "Error Getting Accounts");
                return message;
            }
        }

        @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.POST)
        public Message createBillData(@RequestBody Bill bill) {
            try {
                billService.createBill(bill);
                ArrayList arrayList = new ArrayList();
                Message message = new Message(HttpStatus.CREATED, "Suscess", arrayList);
                return message;


            } catch (Exception e) {
                Message message = new Message(HttpStatus.NOT_FOUND, "Error");
                return message;
            }

        }
//            HttpHeaders responseHeader = new HttpHeaders();
//            URI newBill= ServletUriComponentsBuilder
//                    .fromCurrentRequest()
//                    .path("/{id}")
//                    .buildAndExpand(bill.getId())
//                    .toUri();
//            responseHeader.setLocation(newBill);
//            return new Message(null,responseHeader,HttpStatus.CREATED);

        @RequestMapping(value = "/bills/{billId}", method = RequestMethod.GET)
        public Message getBillData (@PathVariable Long billId){
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(billService.getBill(billId));
                Message message = new Message(HttpStatus.OK,"Got bill with id: " + billId, arrayList );
                return message;
            } catch(Exception e){
                Message message = new Message(HttpStatus.NOT_FOUND, "Error getting bills");
                return message;

            }
        }

        @RequestMapping(value = "/bills/{billId}", method = RequestMethod.PUT)
        public Message updateBill (@RequestBody Bill bill, @PathVariable Long billId ){
            try{
                billService.updateBill(bill,billId);
                ArrayList arrayList = new ArrayList();
                arrayList.add(billService.getBill(billId));
                Message message = new Message(HttpStatus.OK, "Updated Bill with id: " + billId, arrayList);
                return message;
            } catch(Exception e){
                Message message = new Message(HttpStatus.NOT_FOUND, "Error Updating bill with id: " + billId);
                return message;
            }
        }

        @RequestMapping(value = "/bills/{billId}",method = RequestMethod.DELETE)
        public ResponseEntity<?> deleteBill (@PathVariable Long billId){
            billService.deleteBill(billId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }



