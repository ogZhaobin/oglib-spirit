package com.oglib.spirit.boot.collect.common.code;

import com.google.protobuf.MessageLite;
import com.oglib.spirit.boot.collect.common.utils.ParseFromUtils;
import com.oglib.spirit.boot.collect.experience.model.Frame;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.List;

@ChannelHandler.Sharable
public class SecondProtoCode extends MessageToMessageCodec<Frame, MessageLite> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageLite msg, List<Object> out) throws Exception {
        out.add(Frame.newBuilder()
                .setMessageName(msg.getClass().getSimpleName())
                .setData(msg.toByteString())
                .build());
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, Frame msg, List<Object> out) throws Exception {
        out.add(ParseFromUtils.parse(msg));
    }
}
