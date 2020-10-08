package com.samsung.bankservice.service;

import com.samsung.bankservice.entity.GiaoDichThe;
import com.samsung.bankservice.responsitory.GiaoDichTheResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GiaoDichTheService {

    @Autowired
    GiaoDichTheResponsitory accountDeal;

    public List<GiaoDichThe> getAllDealAcount(){
        return  accountDeal.findAll();
    }

    public void deleteAccountDealById(GiaoDichThe giaoDichThe){
        accountDeal.delete(giaoDichThe);

    }

    public GiaoDichThe updateAccountDealById(GiaoDichThe giaoDichThe){
        return accountDeal.save(giaoDichThe);
    }

    public  GiaoDichThe findAcountDualById(int id){
        Optional<GiaoDichThe> giaoDichThe=accountDeal.findById(id);
        return  giaoDichThe.get();
    }

    public  GiaoDichThe saveDealAccount(GiaoDichThe giaoDichThe){
        return  accountDeal.save(giaoDichThe);
    }

}
