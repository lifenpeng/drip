package com.app.appapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiCodeController {

    @Autowired
    private ApiProperties apiProperties;

    @RequestMapping(value = {"/code"},method = RequestMethod.GET)
    @CrossOrigin //解决跨域请求注解
    public String code(@RequestParam("apiUser") String apiUser){

            if(apiUser.equals(apiProperties.getApiUser())){
                return "true";
            }else{
                return "false";
            }

    }

}
