package com.oglib.spirit.boot.source.thread.pool;

import java.util.LinkedList;
import java.util.List;

/**
 * 自定义阻塞队列
 * @author og 19.11.26
 */
public class LinkedBlockQueueSource<T> {

    /**
     * 列表存储
     */
    private List<T> queue = new LinkedList<>();
    /**
     * 任务上限
     */
    private int limit = 10;

    public LinkedBlockQueueSource(int limit){
        this.limit = limit;
    }

    /**
     * 同步方法，当任务达到上限，便会调用wait方法进行阻塞；
     * 否则将任务放入队列，并唤醒dequeue()任务线程
     * @param item
     * @throws InterruptedException
     */
    public synchronized void enqueue(T item) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            this.wait();
        }
        if(this.queue.size() <= limit){
            this.notifyAll();
        }
        this.queue.add(item);
    }

    /**
     * dequeue 同步方法，当队列没有任务时，会调用wait方法进入阻塞；
     * 当任务容量达到上限，会唤醒其他dequeue()线程
     * @return
     * @throws InterruptedException
     */
    public synchronized T dequeue() throws InterruptedException {
        while (this.queue.size() == 0) {
            this.wait();
        }
        if(this.queue.size() == this.limit){
            this.notifyAll();
        }
        return this.queue.remove(0);
    }

    public synchronized int size(){
        return queue.size();
    }

}
