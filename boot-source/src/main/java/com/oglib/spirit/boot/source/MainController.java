package com.oglib.spirit.boot.source;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/say")
    public String say(){
        return "hello";
    }

}
