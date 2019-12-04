package com.oglib.spirit.boot.collect.server.stream.server.init;

import com.oglib.spirit.boot.collect.common.code.DispatchHandler;
import com.oglib.spirit.boot.collect.common.code.SecondProtoCode;
import com.oglib.spirit.boot.collect.experience.model.Frame;
import com.oglib.spirit.boot.collect.server.stream.HandlerPool;
import com.oglib.spirit.boot.collect.common.buffer.IMessageBuffer;
import com.oglib.spirit.boot.collect.common.buffer.InnerQueueBuffer;
import com.oglib.spirit.boot.collect.server.stream.server.INettyService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;

@Component
@ConditionalOnProperty(name="netty.server.type", havingValue = "custom")
public class NettyServer implements INettyService {

    private EventLoopGroup boss = new NioEventLoopGroup(1);

    private EventLoopGroup work = new NioEventLoopGroup(2);

    @PostConstruct
    public void init() throws InterruptedException {

        new Thread(() -> {
            ExecutorService executorService = startHandler();
            shutdownHook(executorService,boss,work);
            try {
                customProtobufRunning(boss, work);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * 启动数据处理队列
     * @return
     */
    private static ExecutorService startHandler(){
        HandlerPool handlerPool = new HandlerPool();
        handlerPool.doHandler();
        return handlerPool.getExecutorService();
    }



}
