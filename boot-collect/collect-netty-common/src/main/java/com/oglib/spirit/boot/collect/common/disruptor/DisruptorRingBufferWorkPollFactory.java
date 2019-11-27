package com.oglib.spirit.boot.collect.common.disruptor;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.ProducerType;
import com.oglib.spirit.boot.collect.common.disruptor.consumer.MessageConsumer;
import com.oglib.spirit.boot.collect.common.disruptor.producer.MessageProducer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

public class DisruptorRingBufferWorkPollFactory {

    private static class RingBufferWorkPool{
        static DisruptorRingBufferWorkPollFactory instance = new DisruptorRingBufferWorkPollFactory();
    }

    private DisruptorRingBufferWorkPollFactory(){}

    public static DisruptorRingBufferWorkPollFactory getInstance(){
        return RingBufferWorkPool.instance;
    }
    private static Map<String, MessageProducer> producers = new ConcurrentHashMap<>();

    private static Map<String, MessageConsumer> consumers = new ConcurrentHashMap<>();

    private RingBuffer<TranslatorDataWrapper> ringBuffer;

    private WorkerPool<TranslatorDataWrapper> workerPool;

    private SequenceBarrier sequenceBarrier;

    public void initAndStart(ProducerType type, int bufferSize, WaitStrategy waitStrategy, MessageConsumer[] messageConsumers){
        //1. 构建RingBuffer对象
        this.ringBuffer = RingBuffer.create(type,
                TranslatorDataWrapper::new,
                bufferSize,
                waitStrategy);
        //2. 设置序号栅栏
        this.sequenceBarrier = this.ringBuffer.newBarrier();
        //3. 工作线程池
        this.workerPool = new WorkerPool<>(ringBuffer, sequenceBarrier, new EventExceptionHandler(), messageConsumers);
        //4. 把所有的消费者置入池中
        for(MessageConsumer consumer : messageConsumers){
            consumers.put(consumer.getConsumerId(), consumer);
        }
        //5. 添加sequences
        this.ringBuffer.addGatingSequences(this.workerPool.getWorkerSequences());
        //6. 启动工作池
        this.workerPool.start(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));
    }

    public MessageProducer getMessageProducer(String messageName){
        MessageProducer producer = producers.get(messageName);
        if(null == producer){
            MessageProducer pnew = new MessageProducer(this.ringBuffer, messageName);
            producers.put(messageName, pnew);
        }
        return producer;
    }
}
