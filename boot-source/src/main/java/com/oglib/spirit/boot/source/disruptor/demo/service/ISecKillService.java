package com.oglib.spirit.boot.source.disruptor.demo.service;

/**
 * 用户
 * @author og 11.13
 */
public interface ISecKillService {

    /**
     * 秒杀
     * @param killId 秒杀id
     * @param userId 用户id
     */
    void startSecKill(Long killId, Long userId);

}
