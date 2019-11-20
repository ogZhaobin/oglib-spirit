package com.oglib.spirit.boot.collect.server.stream;

import com.oglib.spirit.boot.collect.common.AbstractDataHandler;
import com.oglib.spirit.boot.collect.common.annotation.HandlerMapping;
import com.oglib.spirit.boot.collect.experience.model.OrgEntity;
import io.netty.channel.ChannelHandlerContext;

@HandlerMapping("OrgEntity")
public class OrgMessageHandler extends AbstractDataHandler<OrgEntity> {
    @Override
    protected void onEvent(OrgEntity orgEntity, ChannelHandlerContext ctx) throws Exception {
        System.out.println(String.format("%s, text = %s", Thread.currentThread().getName(), orgEntity.toString()));
    }
}
