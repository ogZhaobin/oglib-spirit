package com.oglib.spirit.boot.collect.server.stream.server;

import com.oglib.spirit.boot.collect.common.code.DispatchHandler;
import com.oglib.spirit.boot.collect.common.code.SecondProtoCode;
import com.oglib.spirit.boot.collect.experience.model.Frame;
import com.oglib.spirit.boot.collect.server.stream.HandlerPool;
import com.oglib.spirit.boot.collect.common.buffer.IMessageBuffer;
import com.oglib.spirit.boot.collect.common.buffer.InnerQueueBuffer;
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
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;

@Component
public class NettyServer {

    private EventLoopGroup boss = new NioEventLoopGroup(1);

    private EventLoopGroup work = new NioEventLoopGroup(2);

    @PostConstruct
    public void init() throws InterruptedException {
        ExecutorService executorService = startHandler();
        shutdownHook(executorService,boss,work);
        run(boss, work);
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


    private static void shutdownHook(ExecutorService executorService, EventLoopGroup bossGroup,
                              EventLoopGroup workerGroup){
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            //停止netty线程
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
            IMessageBuffer instance = InnerQueueBuffer.getInstance();

            while (instance.size() != 0){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!executorService.isShutdown()) {
                executorService.shutdownNow();
            }

        }));
    }

    /**
     * netty server 启动
     * @param boss boss线程
     * @param work 工作线程
     * @throws InterruptedException
     */
    private static void run(EventLoopGroup boss, EventLoopGroup work) throws InterruptedException {
        try {
            ServerBootstrap bs = new ServerBootstrap();
            bs.group(boss,work)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()//解码
                                    .addLast(new ProtobufVarint32FrameDecoder())
                                    .addLast(new ProtobufDecoder(Frame.getDefaultInstance()))
                                    //半包问题
                                    .addLast(new ProtobufVarint32LengthFieldPrepender())
                                    .addLast(new ProtobufEncoder())
                                    //集成自定义协议
                                    .addLast(new SecondProtoCode())
                                    //写入队列
                                    .addLast(new DispatchHandler());
                        }
                    });
            ChannelFuture f = bs.bind("127.0.0.1",10990).sync();

            f.channel().closeFuture().sync();
        } finally {
            work.shutdownGracefully();
            boss.shutdownGracefully();
        }
    }
}
