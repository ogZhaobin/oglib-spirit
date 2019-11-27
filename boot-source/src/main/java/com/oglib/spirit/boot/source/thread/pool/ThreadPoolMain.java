package com.oglib.spirit.boot.source.thread.pool;

import java.util.concurrent.TimeUnit;

public class ThreadPoolMain {

    public static void main(String[] args) throws InterruptedException {
        final ThreadPoolService poolService = new ThreadPoolService(5,20);

        for(int i = 0; i < 20; i++){
            poolService.execute(() ->{
                try {
                    TimeUnit.SECONDS.sleep(4);
                    System.out.println(String.format("%s is running add done", Thread.currentThread().getName()));
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

        poolService.shutdown();
    }

}
