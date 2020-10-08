package com.samsung.bankservice.service;

import com.samsung.bankservice.entity.ChucVu;
import com.samsung.bankservice.responsitory.ChucVuResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChucVuService {

    @Autowired
    ChucVuResponsitory chucVuResponsitory;

    public List<ChucVu> getAllPosition(){
        return  chucVuResponsitory.findAll();
    }

    public void deletePositionById(ChucVu chucVu){
        chucVuResponsitory.delete(chucVu);

    }

    public ChucVu UpdatePositionById(ChucVu chucVu){
        return chucVuResponsitory.save(chucVu);
    }

    public  ChucVu findPositonById(int id){
        Optional<ChucVu> chucVu=chucVuResponsitory.findById(id);;
        return  chucVu.get();
    }

    public  ChucVu savePosition(ChucVu chucVu){
        return  chucVuResponsitory.save(chucVu);
    }
}
