package com.ecommerce.spring_ecommerce.controllers.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
    @RequestMapping(value = "/")
    public String home() {
        return "frontend/home";
    }
}
