package com.oglib.spirit.boot.collect.common.code;

import com.google.protobuf.MessageLite;
import com.oglib.spirit.boot.collect.common.disruptor.DisruptorRingBufferWorkPollFactory;
import com.oglib.spirit.boot.collect.common.disruptor.producer.MessageProducer;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * netty 流派发处理
 * @author og 19.11.22
 */
@ChannelHandler.Sharable
public class DisruptorDispatchHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        MessageProducer producer = DisruptorRingBufferWorkPollFactory.getInstance().getMessageProducer("session:01");
        producer.producer((MessageLite) msg, ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
}
