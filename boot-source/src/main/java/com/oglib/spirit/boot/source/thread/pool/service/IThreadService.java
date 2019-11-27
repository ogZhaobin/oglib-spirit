package com.oglib.spirit.boot.source.thread.pool.service;

public interface IThreadService {

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 查看线程是否倍shutdown
     * @return
     */
    boolean isShutdown();

    /**
     * 提交任务到线程池
     * @param runnable
     */
    void execute(Runnable runnable) throws InterruptedException;

}
