package com.samsung.bankservice.controller;


import com.samsung.bankservice.entity.GiaoDichThe;
import com.samsung.bankservice.service.GiaoDichTheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/dealaccount" ,produces = "application/json")
public class DealAccountController {
    @Autowired
    GiaoDichTheService dealAccount;

    @GetMapping("/{id}")
    public GiaoDichThe findPositionById(@PathVariable int id){
        GiaoDichThe giaoDichThe=  dealAccount.findAcountDualById(id);
        return  giaoDichThe;
    }
    @RequestMapping(produces = "application/json")
    @PostMapping
    public GiaoDichThe findPositionById(@RequestBody GiaoDichThe giaoDichThe){
        return dealAccount.saveDealAccount(giaoDichThe);
    }

    @PutMapping("{id}")
    public GiaoDichThe updatePositionById(@PathVariable  int id,@RequestBody GiaoDichThe giaoDichThe){
        dealAccount.findAcountDualById(id);
        return dealAccount.updateAccountDealById(giaoDichThe);
    }

    @DeleteMapping("{id}")
    public void deletePositionById(@PathVariable  int id){
        GiaoDichThe giaoDichThe=dealAccount.findAcountDualById(id);
        dealAccount.deleteAccountDealById(giaoDichThe);
    }

    @GetMapping
    public List<GiaoDichThe> getAllPositon(){
        List<GiaoDichThe> giaoDichThes=dealAccount.getAllDealAcount();
        return giaoDichThes;
    }


}
