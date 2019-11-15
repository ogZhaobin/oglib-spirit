package com.oglib.spirit.boot.source.disruptor.demo;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.ThreadFactory;

public class SecKillMain {

    public static void main(String[] args) {
        SecKillEventFactory factory = new SecKillEventFactory();
        int ringBufferSize = 1024;
        ThreadFactory threadFactory = Thread::new;

        Disruptor<SecKillEvent> disruptor = new Disruptor<SecKillEvent>(factory, ringBufferSize, threadFactory);

        disruptor.handleEventsWith(new SecKillEventConsumer());

        disruptor.start();

        RingBuffer<SecKillEvent> ringBuffer = disruptor.getRingBuffer();

        SecKillEventProducer producer = new SecKillEventProducer(ringBuffer);

        for(int i = 0; i < 10; i ++){
            producer.secKill(i, i);
        }

        disruptor.shutdown();
    }
}
