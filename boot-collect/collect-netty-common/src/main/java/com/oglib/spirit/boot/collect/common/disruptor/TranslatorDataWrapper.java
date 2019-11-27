package com.oglib.spirit.boot.collect.common.disruptor;

import com.google.protobuf.MessageLite;
import io.netty.channel.ChannelHandlerContext;
import lombok.Data;

import java.io.Serializable;

/**
 * 数据传输包装类
 * @author og 19.11.22
 */
@Data
public class TranslatorDataWrapper implements Serializable {

    private static final long serialVersionUID = 7992240964858265321L;
    /**
     * protobuf 消息体
     */
    private MessageLite messageLite;

    /**
     * netty-channel handler
     */
    private ChannelHandlerContext ctx;

}
