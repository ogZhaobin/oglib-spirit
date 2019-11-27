package com.oglib.spirit.boot.source.thread.pool;

/**
 * 线程池类，进行任务提交
 * @author og 19.11.26
 */
public class PoolThread extends Thread {

    private LinkedBlockQueueSource taskQueue = null;

    private boolean stopped = false;

    public PoolThread(LinkedBlockQueueSource queue){
        this.taskQueue = queue;
    }

    public void run(){
        while (!stopped && !Thread.currentThread().isInterrupted()) {
            try {
                Runnable runnable = (Runnable) taskQueue.dequeue();
                runnable.run();
            } catch (InterruptedException e) {
                stopped = true;
                break;
            }
        }
    }

    public synchronized void doStop(){
        stopped = true;
        this.interrupt();
    }

    public synchronized boolean isStopped(){
        return stopped;
    }

}
