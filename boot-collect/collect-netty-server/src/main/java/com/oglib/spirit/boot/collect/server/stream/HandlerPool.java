package com.oglib.spirit.boot.collect.server.stream;

import com.google.protobuf.MessageLite;
import com.oglib.spirit.boot.collect.common.HandlerDataModal;
import com.oglib.spirit.boot.collect.common.utils.HandlerUtils;
import com.oglib.spirit.boot.collect.common.buffer.IMessageBuffer;
import com.oglib.spirit.boot.collect.common.buffer.InnerQueueBuffer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class HandlerPool {

    private int THREAD_POOL_SIZE = 4;

    private final ExecutorService executorService;

    public HandlerPool(){
        executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE, new ThreadFactory() {
            private AtomicInteger i = new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                //自定义线程池中的线程名
                thread.setName("hand-data-thread-" + i.addAndGet(1));
                return thread;
            }
        });
    }

    public void doHandler(){
        for(int i = 0; i < THREAD_POOL_SIZE; i ++){
            executorService.execute(new Runnable() {
                private final IMessageBuffer messageBuffer = InnerQueueBuffer.getInstance();
                @Override
                public void run() {
                    while (!Thread.currentThread().isInterrupted()){
                        handler();
                    }
                }

                @SuppressWarnings("unchecked")
                private void handler(){
                    HandlerDataModal handlerDataModal = messageBuffer.poll();
                    if(handlerDataModal != null){
                        MessageLite messageLite = handlerDataModal.getMessageLite();
                        HandlerUtils.getHandlerInstance(messageLite.getClass().getSimpleName())
                                .handler(messageLite, handlerDataModal.getCtx());
                    }
                }
            });
        }
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public static void main(String[] args) {
        HandlerUtils.getHandlerInstance("UserEntity");
    }
}
