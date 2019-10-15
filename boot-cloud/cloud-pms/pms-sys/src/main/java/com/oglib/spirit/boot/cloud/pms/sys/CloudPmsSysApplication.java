package com.oglib.spirit.boot.cloud.pms.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.oglib.spirit.boot.cloud.pms.sys.mapper")
public class CloudPmsSysApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudPmsSysApplication.class, args);
    }
}
