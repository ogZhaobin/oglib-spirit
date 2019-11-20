package com.oglib.spirit.boot.collect.common;

import com.google.protobuf.MessageLite;
import io.netty.channel.ChannelHandlerContext;

/**
 * 数据处理
 * @param <T> 消息体
 * @author og 19.11.18
 */
public interface DataHandler<T extends MessageLite> {
    /**
     * 消息处理方法
     * @param t 消息
     * @param ctx channel全局上下文对象
     */
    void handler(T t, ChannelHandlerContext ctx);

}
