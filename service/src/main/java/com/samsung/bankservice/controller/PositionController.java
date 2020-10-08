package com.samsung.bankservice.controller;

import com.samsung.bankservice.entity.ChucVu;
import com.samsung.bankservice.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/position",produces = "application/json")
public class PositionController {
    @Autowired
    ChucVuService chucVuService;

    @GetMapping("find/{id}")
    public ChucVu findPositionById(@PathVariable  int id){
        ChucVu chucVu=  chucVuService.findPositonById(id);
        return  chucVu;
    }
    @RequestMapping(method = RequestMethod.POST,produces = "application/json")
    public ChucVu findPositionById(@RequestBody ChucVu chucVu){
        return chucVuService.savePosition(chucVu);
    }

    @PutMapping(path = "update/{id}" ,produces = "application/json")
    public ChucVu updatePositionById(@PathVariable  int id,@RequestBody ChucVu chucVu){
         chucVuService.findPositonById(id);
        return  chucVuService.UpdatePositionById(chucVu);
    }

    @GetMapping("delete/{id}")
    public void deletePositionById(@PathVariable  int id){
        ChucVu chucVu=  chucVuService.findPositonById(id);
       chucVuService.deletePositionById(chucVu);
    }

    @GetMapping
    public List<ChucVu> getAllPositon(){
        List<ChucVu> chucVus=chucVuService.getAllPosition();
        return chucVus;
    }
}
