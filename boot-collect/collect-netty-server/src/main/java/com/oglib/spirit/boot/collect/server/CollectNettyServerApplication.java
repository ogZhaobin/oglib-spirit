package com.oglib.spirit.boot.collect.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class CollectNettyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollectNettyServerApplication.class,args);
    }

}
