package com.oglib.spirit.boot.source.thread;

public class ThreadSynchronizedA implements Runnable{
    @Override
    public void run() {
        synchronized (this){
            String threadName = Thread.currentThread().getName();
            System.out.println(String.format("ThreadName=%s开始执行",threadName));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("ThreadName=%s执行结束，耗时%sms",threadName, 10));
        }
    }

    public static void main(String[] args) {
        ThreadSynchronizedA t = new ThreadSynchronizedA();
        ThreadSynchronizedA t1 = new ThreadSynchronizedA();
        new Thread(t).start();
        new Thread(t1).start();
    }
}
