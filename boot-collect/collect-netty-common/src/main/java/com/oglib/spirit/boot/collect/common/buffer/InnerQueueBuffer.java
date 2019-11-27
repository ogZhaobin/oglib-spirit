package com.oglib.spirit.boot.collect.common.buffer;

import com.oglib.spirit.boot.collect.common.HandlerDataModal;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class InnerQueueBuffer implements IMessageBuffer{

    private int MAX_LENGTH = 500;

    private final BlockingQueue<HandlerDataModal> queue = new LinkedBlockingQueue<>();


    private static InnerQueueBuffer instance = new InnerQueueBuffer();

    private InnerQueueBuffer() {
    }

    public static InnerQueueBuffer getInstance() {
        return instance;
    }


    @Override
    public boolean offer(HandlerDataModal handlerDataModal) {
        if (queue.size() > MAX_LENGTH) {
            //todo 处理队列超过规定长度
            return false;
        }
        queue.offer(handlerDataModal);
        return false;
    }

    @Override
    public HandlerDataModal poll() {
        try {
            //使用阻塞方法防止消费者线程空转
            return queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int size() {
        return queue.size();
    }
}
