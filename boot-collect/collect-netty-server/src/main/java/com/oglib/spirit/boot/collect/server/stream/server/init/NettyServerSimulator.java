package com.oglib.spirit.boot.collect.server.stream.server.init;

import com.oglib.spirit.boot.collect.server.stream.server.INettyService;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
@ConditionalOnProperty(name="netty.server.type", havingValue = "simulator")
public class NettyServerSimulator implements INettyService {
    private EventLoopGroup boss = new NioEventLoopGroup(1);

    private EventLoopGroup work = new NioEventLoopGroup(2);

    @Override
    @PostConstruct
    public void init() throws Exception {
        shutdownHook(boss,work);
        runningForString(boss, work);
    }
}
