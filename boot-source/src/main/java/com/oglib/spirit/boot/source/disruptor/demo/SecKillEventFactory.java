package com.oglib.spirit.boot.source.disruptor.demo;


import com.lmax.disruptor.EventFactory;

/**
 * 获取实例
 * @author og 19.11.13
 */
public class SecKillEventFactory implements EventFactory<SecKillEvent> {
    @Override
    public SecKillEvent newInstance() {
        return new SecKillEvent();
    }
}
