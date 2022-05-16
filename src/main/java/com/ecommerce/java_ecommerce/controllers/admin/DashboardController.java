package com.ecommerce.java_ecommerce.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    @RequestMapping(value = "/admin")
    public String index(){
        return "admin/dashboard/index";
    }





}
