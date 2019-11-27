package com.oglib.spirit.boot.source.thread.pool.facotry;

/**
 * 线程工厂
 * @author 19.11.26
 */
@FunctionalInterface
public interface IThreadFactory {

    /**
     * 创建线程
     * @param runnable
     * @return
     */
    Thread createThread(Runnable runnable);

}
