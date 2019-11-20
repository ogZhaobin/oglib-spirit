package com.oglib.spirit.boot.collect.common;

import com.google.protobuf.MessageLite;
import io.netty.channel.ChannelHandlerContext;

/**
 * 抽象的数据处理
 * @param <T>
 * @author og 19.11.19
 */
public abstract class AbstractDataHandler<T extends MessageLite> implements DataHandler<T> {
    @Override
    public void handler(T t, ChannelHandlerContext ctx) {
        try {
            this.onEvent(t, ctx);
        } catch (Exception e) {
            exceptionCaught(e);
        }
    }

    /**
     * 暴露给子类的业务逻辑处理方法
     *
     * @param t   消息对象
     * @param ctx
     * @throws Exception
     */
    protected abstract void onEvent(T t, ChannelHandlerContext ctx) throws Exception;

    /**
     * 异常处理
     *
     * @param cause
     */
    void exceptionCaught(Throwable cause) {

    }
}
