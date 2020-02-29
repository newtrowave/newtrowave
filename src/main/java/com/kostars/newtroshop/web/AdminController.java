package com.kostars.newtroshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping("")
    public String index() {
        return "admin/index";
    }

    @GetMapping("/{path}")
    public String eCommerce(@PathVariable String path) {
        return "admin/" + path;
    }
}
