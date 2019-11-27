package com.oglib.spirit.boot.collect.common.disruptor.producer;

import com.google.protobuf.MessageLite;
import com.lmax.disruptor.RingBuffer;
import com.oglib.spirit.boot.collect.common.disruptor.TranslatorDataWrapper;
import io.netty.channel.ChannelHandlerContext;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageProducer {

    private RingBuffer<TranslatorDataWrapper> ringBuffer;

    private String producerId;

    public void producer(MessageLite msg, ChannelHandlerContext ctx){
        long sequence = ringBuffer.next();
        try {
            TranslatorDataWrapper wrapper = ringBuffer.get(sequence);
            wrapper.setMessageLite(msg);
            wrapper.setCtx(ctx);
        } finally {
            ringBuffer.publish(sequence);
        }
    }

}
