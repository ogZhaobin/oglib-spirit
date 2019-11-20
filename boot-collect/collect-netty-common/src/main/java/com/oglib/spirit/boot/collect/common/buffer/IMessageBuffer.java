package com.oglib.spirit.boot.collect.common.buffer;

import com.oglib.spirit.boot.collect.common.HandlerDataModal;

public interface IMessageBuffer {
    /**
     * 放入一个handlerData
     */
    boolean offer(HandlerDataModal handlerDataModal);

    /**
     * 取出一个handlerData
     */
    HandlerDataModal poll();

    /**
     * 当前buffer中数据量
     * @return
     */
    int size();
}
