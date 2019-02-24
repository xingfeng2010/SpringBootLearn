package com.example;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(ModelMap map){//ModelMap转发值的作用
        map.addAttribute("name","FreeMarker");
        return "index";
    }
}
