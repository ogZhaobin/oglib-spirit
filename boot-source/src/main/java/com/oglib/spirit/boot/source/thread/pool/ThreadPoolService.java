package com.oglib.spirit.boot.source.thread.pool;

import com.oglib.spirit.boot.source.thread.pool.service.IThreadService;

import java.util.ArrayDeque;
import java.util.Queue;

public class ThreadPoolService implements IThreadService {
    /**
     * 任务队列
     */
    private LinkedBlockQueueSource<Runnable> taskQueue = null;
    /**
     * 线程容器-工作线程
     */
    private Queue<PoolThread> threads = new ArrayDeque<>();

    private boolean isShutdown = false;

    public ThreadPoolService(int initSize, int maxNoOfTasks){
        taskQueue = new LinkedBlockQueueSource<>(maxNoOfTasks);
        for(int i = 0; i < initSize; i ++){
            threads.add(new PoolThread(taskQueue));
        }
        threads.forEach(Thread::start);
    }

    @Override
    public void shutdown() {
        this.isShutdown = true;
        threads.forEach(PoolThread::doStop);
    }

    @Override
    public boolean isShutdown() {
        return isShutdown;
    }

    @Override
    public void execute(Runnable runnable) throws InterruptedException {
        if(this.isShutdown){
            throw new IllegalArgumentException("ThreadPool is stopped");
        }
        taskQueue.enqueue(runnable);
    }
}
