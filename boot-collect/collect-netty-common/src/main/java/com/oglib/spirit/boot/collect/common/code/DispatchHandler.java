package com.oglib.spirit.boot.collect.common.code;

import com.google.protobuf.MessageLite;
import com.oglib.spirit.boot.collect.common.HandlerDataModal;
import com.oglib.spirit.boot.collect.common.buffer.IMessageBuffer;
import com.oglib.spirit.boot.collect.common.buffer.InnerQueueBuffer;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

@ChannelHandler.Sharable
public class DispatchHandler extends ChannelInboundHandlerAdapter {

    private final IMessageBuffer buffer = InnerQueueBuffer.getInstance();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //把解包完成的对象封装放入队列中异步处理
        buffer.offer(new HandlerDataModal((MessageLite) msg, ctx));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
}

