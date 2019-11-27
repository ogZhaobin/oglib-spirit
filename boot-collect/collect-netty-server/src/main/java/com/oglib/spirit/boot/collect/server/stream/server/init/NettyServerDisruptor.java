package com.oglib.spirit.boot.collect.server.stream.server.init;

import com.oglib.spirit.boot.collect.server.stream.server.INettyService;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Disruptor netty server
 * @author og 19.11.26
 */
@Component
@ConditionalOnProperty(name="netty.server.type", havingValue = "disruptor")
public class NettyServerDisruptor implements INettyService {
    private EventLoopGroup boss = new NioEventLoopGroup(1);

    private EventLoopGroup work = new NioEventLoopGroup(2);

    /**
     * 初始化
     * @throws InterruptedException
     */
    @Override
    @PostConstruct
    public void init() throws InterruptedException {
        shutdownHook(boss,work);
        runningForString(boss, work);
    }

}
