package com.app.appapi;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
    public String Index(){
        return "forward:/index.html";
    }

}
