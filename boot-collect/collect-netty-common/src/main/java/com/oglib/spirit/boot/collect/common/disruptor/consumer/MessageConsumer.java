package com.oglib.spirit.boot.collect.common.disruptor.consumer;

import com.lmax.disruptor.WorkHandler;
import com.oglib.spirit.boot.collect.common.disruptor.TranslatorDataWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 数据消费
 * @author og 19/11/22
 */
@Data
@AllArgsConstructor
public abstract class MessageConsumer implements WorkHandler<TranslatorDataWrapper> {

    private String consumerId;

    @Override
    public void onEvent(TranslatorDataWrapper event) throws Exception {
        this.processor(event);
    }

    protected abstract void processor(TranslatorDataWrapper wrapper);
}
