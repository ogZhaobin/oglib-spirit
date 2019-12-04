package com.oglib.spirit.boot.collect.server.stream.server.container;


import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.List;

public class ChannelContainer {

    private static final List<ChannelHandlerContext> CHANNEL = new ArrayList<>(1);

    public static synchronized ChannelHandlerContext handler(ChannelHandlerContext ctx, ChannelConstants.ChannelOption option){
        if(option.equals(ChannelConstants.ChannelOption.PUT)){
            CHANNEL.add(ctx);
            return ctx;
        }else if(option.equals(ChannelConstants.ChannelOption.REMOVE)){
            if(CHANNEL.size() > 0){
               return CHANNEL.remove(0);
            }
        }
        return CHANNEL.size() > 0 ? CHANNEL.get(0) : null;
    }

    public static void main(String[] args) {
        ChannelConstants.ChannelOption o1 = ChannelConstants.ChannelOption.PUT;
        ChannelConstants.ChannelOption o2 = ChannelConstants.ChannelOption.PUT;
        System.out.println(o1.equals(o2));
    }

}
