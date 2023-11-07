package com.cody.fleetapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName: ApplicationController
 * Package: com.cody.fleetapp
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/10/18 - 18:31
 * @Version: v1.0
 **/
@Controller
public class ApplicationController {

    @GetMapping("/index")
    public String goHome(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }
}
