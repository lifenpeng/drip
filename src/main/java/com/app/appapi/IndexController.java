package com.app.appapi;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping("/index")
    public String Index(){
        return "forward:/index.html";
    }

}
