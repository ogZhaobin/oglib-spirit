package com.oglib.spirit.boot.collect.server.stream;

import com.oglib.spirit.boot.collect.server.stream.server.container.ChannelConstants;
import com.oglib.spirit.boot.collect.server.stream.server.container.ChannelContainer;
import io.netty.channel.*;

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

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ChannelContainer.handler(ctx, ChannelConstants.ChannelOption.PUT);
    }

    /**
     * Calls {@link ChannelHandlerContext#fireChannelInactive()} to forward
     * to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
     *
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        ChannelContainer.handler(ctx, ChannelConstants.ChannelOption.REMOVE);
    }

}
