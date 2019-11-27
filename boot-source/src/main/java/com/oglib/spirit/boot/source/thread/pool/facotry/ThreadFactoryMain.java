package com.oglib.spirit.boot.source.thread.pool.facotry;

import java.util.concurrent.TimeUnit;

public class ThreadFactoryMain {

    public static void main(String[] args) throws InterruptedException {
        final ThreadPoolExecutorSource executorSource = new ThreadPoolExecutorSource(5, 20);
        for(int i = 0; i < 20; i++){
            executorSource.execute(() ->{
                try {
                    TimeUnit.SECONDS.sleep(4);
                    System.out.println(String.format("%s is running and done", Thread.currentThread().getName()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        int count = 0;
        while (count < 10){
            count ++;
            System.out.println("-----------------------");
            TimeUnit.SECONDS.sleep(2);
        }
        executorSource.shutdown();
    }
}
