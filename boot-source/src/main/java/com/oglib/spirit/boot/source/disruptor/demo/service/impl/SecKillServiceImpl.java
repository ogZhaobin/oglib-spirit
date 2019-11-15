package com.oglib.spirit.boot.source.disruptor.demo.service.impl;

import com.oglib.spirit.boot.source.disruptor.demo.service.ISecKillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 秒杀服务处理类
 * @author og 11.13
 */
@Slf4j
@Component
public class SecKillServiceImpl implements ISecKillService {

    @Override
    public void startSecKill(Long killId, Long userId) {
        log.info("killId = {}, userId = {}", killId, userId);
    }
}
