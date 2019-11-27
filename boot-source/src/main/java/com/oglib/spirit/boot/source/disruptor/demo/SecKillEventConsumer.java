package com.oglib.spirit.boot.source.disruptor.demo;

import com.lmax.disruptor.EventHandler;
import com.oglib.spirit.boot.source.disruptor.demo.service.ISecKillService;
import com.oglib.spirit.boot.source.disruptor.demo.service.impl.SecKillServiceImpl;
import com.oglib.spirit.boot.utils.SpringBeanHolderUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * 数据消费者
 * @author og 19.11.13
 */
@Slf4j
public class SecKillEventConsumer implements EventHandler<SecKillEvent> {


    @Override
    public void onEvent(SecKillEvent event, long sequence, boolean endOfBatch) throws Exception {
        log.info("sequence = {}, endOfBatch = {}", sequence, endOfBatch);
    }
}
