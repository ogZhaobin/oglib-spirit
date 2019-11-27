package com.oglib.spirit.boot.source.thread.pool.facotry;

import com.oglib.spirit.boot.source.thread.pool.LinkedBlockQueueSource;
import com.oglib.spirit.boot.source.thread.pool.PoolThread;
import com.oglib.spirit.boot.source.thread.pool.service.IThreadService;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorSource implements IThreadService {

    /**
     * 任务队列，用来存储提交的任务
     */
    private LinkedBlockQueueSource<Runnable> taskQueue = null;

    /**
     * 线程池中存储线程的容器。
     */
    private Queue<PoolThread> threads = new ArrayDeque<>();


    /**
     * 默认线程工厂
     */
    private IThreadFactory DEFAULT_THREAD_FACTORY = new DefaultThreadFactory();

    private boolean isShutdown = false;

    /**
     * 线程池执行构造器
     * @param initSize 工作线程大小
     * @param maxNoOfTasks 最大任务数
     */
    public ThreadPoolExecutorSource(int initSize, int maxNoOfTasks){
        taskQueue = new LinkedBlockQueueSource<>(maxNoOfTasks);
        for(int i = 0; i < initSize; i ++){
            newThread();
        }
        threads.forEach(Thread::start);
    }

    private void newThread(){
        PoolThread poolThread = new PoolThread(taskQueue);
//        Thread thread = DEFAULT_THREAD_FACTORY.createThread(poolThread);
        threads.add(poolThread);
    }

    @Override
    public void shutdown() {
        this.isShutdown = true;
        threads.forEach(PoolThread::doStop);
    }
    @Override
    public boolean isShutdown() {
        return false;
    }
    @Override
    public synchronized void execute(Runnable runnable) throws InterruptedException {
        if(this.isShutdown){
            throw new IllegalStateException("ThreadPoolExecutor state illegal");
        }
        taskQueue.enqueue(runnable);
    }



    private static class DefaultThreadFactory implements IThreadFactory{
        private static final AtomicInteger GROUP_COUNTER = new AtomicInteger(1);
        private static final ThreadGroup group = new ThreadGroup(String.format("customThreadPool-%s",GROUP_COUNTER.getAndDecrement()));
        private static final AtomicInteger COUNTER = new AtomicInteger(0);
        @Override
        public Thread createThread(Runnable runnable) {
            return new Thread(group, runnable, String.format("thread-pool%s", COUNTER.getAndDecrement()));
        }
    }
}
