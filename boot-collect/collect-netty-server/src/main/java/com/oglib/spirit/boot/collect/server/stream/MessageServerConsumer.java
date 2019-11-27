package com.oglib.spirit.boot.collect.server.stream;

import com.oglib.spirit.boot.collect.common.disruptor.TranslatorDataWrapper;
import com.oglib.spirit.boot.collect.common.disruptor.consumer.MessageConsumer;

/**
 *
 *
 */
public class MessageServerConsumer extends MessageConsumer {


    public MessageServerConsumer(String name){
        super(name);
    }

    @Override
    protected void processor(TranslatorDataWrapper wrapper) {
    }
}

