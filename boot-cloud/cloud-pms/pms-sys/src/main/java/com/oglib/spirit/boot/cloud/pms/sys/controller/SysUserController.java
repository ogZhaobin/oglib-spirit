package com.oglib.spirit.boot.cloud.pms.sys.controller;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.oglib.spirit.boot.cloud.pms.sys.entity.SysUserInf;
import com.oglib.spirit.boot.cloud.pms.sys.mapper.ISysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@Scope("prototype")
@RequestMapping("/pms/sys")
public class SysUserController {

    @Resource
    private ISysUserMapper userMapper;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/find/server")
    public List<ServiceInstance> findServer(){
        return discoveryClient.getInstances("pms-sys");
    }

    @GetMapping(path = "/insert")
    public List<SysUserInf> insertUser(){
        SysUserInf user = new SysUserInf();
        user.setUserName("John");
        user.setUserPwd("French~");
        userMapper.insert(user);
        return userMapper.selectAll();
    }

    @GetMapping("/{id}")
    public  SysUserInf findById(@PathVariable("id") Integer id){
        log.info("我被请求了");
        return userMapper.selectByPrimaryKey(id);
    }
}
