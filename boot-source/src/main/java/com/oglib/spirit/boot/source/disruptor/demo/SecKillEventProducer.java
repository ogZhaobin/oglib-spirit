package com.oglib.spirit.boot.source.disruptor.demo;

import com.lmax.disruptor.EventTranslatorVararg;
import com.lmax.disruptor.RingBuffer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 秒杀消息生产者
 * @author og 11.13
 */
@Data
@Slf4j
public class SecKillEventProducer {

    private static EventTranslatorVararg<SecKillEvent> translator = (event, sequence, args) -> {
        event.setKillId((Long)args[0]);
        event.setUserId((Long)args[1]);
    };

    public SecKillEventProducer(RingBuffer<SecKillEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    private final RingBuffer<SecKillEvent> ringBuffer;

    public void secKill(long killId, long userId){
        this.ringBuffer.publishEvent(translator, killId, userId);
    }
}
