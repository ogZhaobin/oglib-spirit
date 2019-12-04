package com.oglib.spirit.boot.collect.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class CollectNettyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollectNettyServerApplication.class,args);
    }
}
