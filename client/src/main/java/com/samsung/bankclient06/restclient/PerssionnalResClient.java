package com.samsung.bankclient06.restclient;

import com.samsung.bankclient06.entity.NhanVien;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class PerssionnalResClient {
    private RestTemplate rest = new RestTemplate();

    private static final String USER_REST_URL = "http://localhost:8082/persionnel/";
    public NhanVien getPersionnalById(int id) {

        NhanVien nhanVien = rest.getForObject(USER_REST_URL + id, NhanVien.class);

        return nhanVien;
    }
    public void updatePersionnal(int manhanvien,NhanVien nhanVien){
        rest.put("http://localhost:8082/persionnel/"+manhanvien, nhanVien,NhanVien.class);

    }

    public List<NhanVien> getAllPersionnal (){
        List<NhanVien> nhanViens= Arrays.asList(rest.getForObject(USER_REST_URL, NhanVien[].class));
        return  nhanViens;
    }

    public void deletePersionalById (int id){
        rest.delete(  "http://localhost:8082/persionnel/"+id,NhanVien.class);
    }

    public void savePersional(NhanVien nhanVien){

        rest.postForObject(USER_REST_URL, nhanVien, NhanVien.class);
    }

}
