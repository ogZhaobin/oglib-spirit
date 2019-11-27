package com.oglib.spirit.boot.collect.server.stream;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

@ChannelHandler.Sharable
public class SimulatorMessageHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        String temp = String.valueOf(msg);
        if("hello".equals(temp.toLowerCase())){
            ctx.writeAndFlush("get it");
        }else {
            ctx.writeAndFlush("please say 'hello'");
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

}
