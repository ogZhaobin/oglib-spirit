package com.oglib.spirit.boot.collect.server.stream.server;

import com.oglib.spirit.boot.collect.common.buffer.IMessageBuffer;
import com.oglib.spirit.boot.collect.common.buffer.InnerQueueBuffer;
import com.oglib.spirit.boot.collect.common.code.DispatchHandler;
import com.oglib.spirit.boot.collect.common.code.DisruptorDispatchHandler;
import com.oglib.spirit.boot.collect.common.code.SecondProtoCode;
import com.oglib.spirit.boot.collect.experience.model.Frame;
import com.oglib.spirit.boot.collect.server.stream.SimulatorMessageHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.concurrent.ExecutorService;

/**
 * netty 接口
 * @author og 19.11.15
 */
public interface INettyService {

    /**
     * 服务初始化
     * @throws Exception
     */
    void init() throws Exception;

    /**
     * 友好退出
     * @param executorService 线程池
     * @param bossGroup sync队列
     * @param workerGroup acceptor队列
     */
    default void shutdownHook(ExecutorService executorService, EventLoopGroup bossGroup,
                              EventLoopGroup workerGroup) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            //停止netty线程
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
            IMessageBuffer instance = InnerQueueBuffer.getInstance();
            while (instance.size() != 0) {
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
     * 仅关闭netty
     * @param bossGroup sync
     * @param workerGroup accept
     */
    default void shutdownHook( EventLoopGroup bossGroup,
                              EventLoopGroup workerGroup) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            //停止netty线程
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
            IMessageBuffer instance = InnerQueueBuffer.getInstance();
            while (instance.size() != 0) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));
    }

    /**
     * netty server 启动
     * @param boss boss线程
     * @param work 工作线程
     * @throws InterruptedException
     */
    default void customProtobufRunning(EventLoopGroup boss, EventLoopGroup work) throws InterruptedException {
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
            ChannelFuture f = bs.bind(10890).sync();

            f.channel().closeFuture().sync();
        } finally {
            work.shutdownGracefully();
            boss.shutdownGracefully();
        }
    }

    /**
     * 字符串
     * @param boss sync
     * @param work accept
     * @throws InterruptedException
     */
    default void runningForString(EventLoopGroup boss, EventLoopGroup work) throws InterruptedException {
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
                                    .addLast(new StringDecoder())
                                    .addLast(new StringEncoder())
                                    .addLast(new SimulatorMessageHandler());
                        }
                    });
            ChannelFuture f = bs.bind(10890).sync();

            f.channel().closeFuture().sync();
        } finally {
            work.shutdownGracefully();
            boss.shutdownGracefully();
        }
    }

    /**
     * netty for disruptor
     * @param boss sync
     * @param work accept
     * @throws InterruptedException
     */
    default void runningForDisruptor(EventLoopGroup boss, EventLoopGroup work) throws InterruptedException{
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
                                    .addLast(new DisruptorDispatchHandler());
                        }
                    });
            ChannelFuture f = bs.bind(10890).sync();
            f.channel().closeFuture().sync();
        } finally {
            work.shutdownGracefully();
            boss.shutdownGracefully();
        }
    }
}
