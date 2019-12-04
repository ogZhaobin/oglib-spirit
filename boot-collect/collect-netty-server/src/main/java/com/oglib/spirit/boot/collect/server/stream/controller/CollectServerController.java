package com.oglib.spirit.boot.collect.server.stream.controller;

import com.oglib.spirit.boot.collect.server.stream.server.container.ChannelConstants;
import com.oglib.spirit.boot.collect.server.stream.server.container.ChannelContainer;
import io.netty.channel.ChannelHandlerContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collect")
public class CollectServerController {

    @RequestMapping("/send")
    public String send(@RequestParam("msg") String msg){
        ChannelHandlerContext ctx = ChannelContainer.handler(null, ChannelConstants.ChannelOption.GET);
        if(null == ctx){
            return "channel none";
        }
        if(StringUtils.isEmpty(msg)){
            return "illegal arguments";
        }
        ctx.pipeline().lastContext().pipeline().writeAndFlush(msg);
        return "success";
    }
}
