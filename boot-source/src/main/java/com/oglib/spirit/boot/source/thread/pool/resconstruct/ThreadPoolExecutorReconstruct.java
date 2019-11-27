package com.oglib.spirit.boot.source.thread.pool.resconstruct;

import com.oglib.spirit.boot.source.thread.pool.service.IThreadService;

/**
 * 线程池重构
 * @author og 19.11.27
 */
public class ThreadPoolExecutorReconstruct implements IThreadService {
    @Override
    public void shutdown() {

    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public void execute(Runnable runnable) throws InterruptedException {

    }
}
