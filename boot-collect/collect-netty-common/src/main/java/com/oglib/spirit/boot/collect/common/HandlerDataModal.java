package com.oglib.spirit.boot.collect.common;

import com.google.protobuf.MessageLite;
import io.netty.channel.ChannelHandlerContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  protobuff and channel
 * @author og 11.18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HandlerDataModal {

    private MessageLite messageLite;

    private ChannelHandlerContext ctx;

}
