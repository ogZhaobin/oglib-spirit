package com.oglib.spirit.boot.collect.server.stream;

import com.oglib.spirit.boot.collect.common.AbstractDataHandler;
import com.oglib.spirit.boot.collect.common.annotation.HandlerMapping;
import com.oglib.spirit.boot.collect.experience.model.UserEntity;
import io.netty.channel.ChannelHandlerContext;

@HandlerMapping("UserEntity")
public class UserMessageHandler extends AbstractDataHandler<UserEntity> {
    @Override
    protected void onEvent(UserEntity userEntity, ChannelHandlerContext ctx) throws Exception {
        System.out.println(String.format("%s, text = %s", Thread.currentThread().getName(), userEntity.toString()));
    }
}
