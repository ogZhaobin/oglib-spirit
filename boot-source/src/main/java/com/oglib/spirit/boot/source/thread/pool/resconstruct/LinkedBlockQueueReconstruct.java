package com.oglib.spirit.boot.source.thread.pool.resconstruct;

import java.util.LinkedList;
import java.util.List;

/**
 * 重构任务队列
 * @param <T>
 * @author og 19.11.27
 */
public class LinkedBlockQueueReconstruct<T> {

    /**
     * 任务链表
     */
    private List<T> queue = new LinkedList<>();
    /**
     * 最大任务数
     */
    private int limit = 10;
    /**
     * 拒绝策略
     */
    private DenyPolicyReconstruct denyPolicy;
    /**
     * 线程池
     */
    private ThreadPoolExecutorReconstruct threadPool;

    public LinkedBlockQueueReconstruct(int limit, DenyPolicyReconstruct denyPolicy, ThreadPoolExecutorReconstruct threadPool){
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }

}
