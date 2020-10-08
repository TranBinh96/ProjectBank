package com.samsung.bankclient06.restclient;

import com.samsung.bankclient06.entity.ChucVu;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class PositionRestClient {
    private RestTemplate rest = new RestTemplate();
    private static final String USER_REST_URL = "http://localhost:8082/position/";
    public ChucVu findAllPositionById(int id) {
        ChucVu chucVu = rest.getForObject("http://localhost:8082/position/find/" + id, ChucVu.class);
        return chucVu;
    }

    public void updatePosition(int machucvu,ChucVu chucVu){

        rest.put("http://localhost:8082/position/update/"+machucvu, chucVu,ChucVu.class);

    }

    public List<ChucVu> getAllPositon (){
        List<ChucVu> chucVus= Arrays.asList(rest.getForObject(USER_REST_URL, ChucVu[].class));
        return  chucVus;
    }

    public void deletePositonById (int id){
        ChucVu chucVu = rest.getForObject(  "http://localhost:8082/position/delete/"+id,ChucVu.class);
    }

    public void savePosition(ChucVu chucVu){
        rest.postForObject(USER_REST_URL, chucVu, ChucVu.class);

    }
}
