package com.example.its.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // view名 login.html 拡張子省略&resource内のパス
    }

    @GetMapping("/logout")
    public String showLogoutForm() {
        return "logout";
    }
}
