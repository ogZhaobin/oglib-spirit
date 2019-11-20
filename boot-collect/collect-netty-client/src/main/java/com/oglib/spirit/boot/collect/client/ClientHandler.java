package com.oglib.spirit.boot.collect.client;

import com.oglib.spirit.boot.collect.experience.model.OrgEntity;
import com.oglib.spirit.boot.collect.experience.model.UserEntity;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Timer;

@ChannelHandler.Sharable
public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //连接建立以后定时给server端发消息
        ctx.writeAndFlush(UserEntity.newBuilder().setAge(15).setSex(1).setName("Bin Zhao").build());
        ctx.writeAndFlush(OrgEntity.newBuilder().setOrgNo("NO0001").setOrgName("Beacon-ai").build());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("客户端收到："+ msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

}
