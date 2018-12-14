package com.app.appapi;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    //调用定义接口
    @Autowired
    private LoginRepository loginRepository;
    @PostMapping(value = "/login")
    @CrossOrigin
    public HashMap LoginCode(@RequestBody String data){

        //for(int i=0;i<loginRepository.findAll().size();i++){
        //    System.out.println(loginRepository.findAll().get(i).getUser());
        //}

        System.out.println(data);

        Gson gson = new Gson();
        Map<String, Object> admin = new HashMap<String, Object>();
        admin = gson.fromJson(data, admin.getClass());

        String user = admin.get("user").toString();
        String password = admin.get("password").toString();

        String is_user = loginRepository.findById(1).get().getUser();
        String is_password = loginRepository.findById(1).get().getPassword();

        HashMap info = new HashMap();

        if(is_user.equals(user)&&is_password.equals(password)){
            info.put("code",true);
        }else{
            info.put("code",false);
        }

        return info;

    }

}
