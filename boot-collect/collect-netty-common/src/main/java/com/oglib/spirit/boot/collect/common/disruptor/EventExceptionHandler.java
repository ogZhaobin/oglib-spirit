package com.oglib.spirit.boot.collect.common.disruptor;

import com.lmax.disruptor.ExceptionHandler;

public class EventExceptionHandler implements ExceptionHandler<TranslatorDataWrapper> {
    @Override
    public void handleEventException(Throwable ex, long sequence, TranslatorDataWrapper event) {

    }

    @Override
    public void handleOnStartException(Throwable ex) {

    }

    @Override
    public void handleOnShutdownException(Throwable ex) {

    }
}
