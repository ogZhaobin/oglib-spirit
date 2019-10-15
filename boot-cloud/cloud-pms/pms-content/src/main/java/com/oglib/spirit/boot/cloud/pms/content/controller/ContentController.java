package com.oglib.spirit.boot.cloud.pms.content.controller;

import com.oglib.spirit.boot.cloud.pms.content.entity.ContentInf;
import com.oglib.spirit.boot.cloud.pms.content.entity.dto.ShareDTO;
import com.oglib.spirit.boot.cloud.pms.content.entity.dto.SysUserDTO;
import com.oglib.spirit.boot.cloud.pms.content.mapper.IContentMapper;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@RestController
@Scope("prototype")
@RequestMapping("/pms/content")
public class ContentController {

    @Resource
    private IContentMapper contentMapper;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 内容插入
     * @return
     */
    @GetMapping("/insert")
    public List<ContentInf> insert(){
        Random random = new Random(100);
        ContentInf ci = new ContentInf();
        ci.setContent(String.format("sn:%s 内容", random.nextInt()));
        ci.setContentTitle("title");
        ci.setCreateTime(System.currentTimeMillis());
        contentMapper.insert(ci);
        return contentMapper.selectAll();
    }

    /**
     * 查看内容
     * @param id 主键
     * @return
     */
    @GetMapping("/{id}")
    public ShareDTO findById(@PathVariable Integer id){
        ShareDTO share = new ShareDTO();
        share.setContent(contentMapper.selectByPrimaryKey(id));

        List<ServiceInstance> instances = discoveryClient.getInstances("pms-sys");
        String targetUrl = instances.stream()
                .map(instance -> instance.getUri().toString() + "pms/sys/{id}")
                .findFirst().orElseThrow(() -> new IllegalArgumentException("当前没有服务实例"));
        SysUserDTO userDTO = restTemplate.getForObject("http://pms-sys/pms/sys/{id}", SysUserDTO.class, id);
        share.setUserDTO(userDTO);
        return  share;
    }

}
