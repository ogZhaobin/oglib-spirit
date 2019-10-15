package com.oglib.spirit.boot.source.thread.demo;

/**
 * 学自 : https://blog.csdn.net/zombres/article/details/80497515
 * @author og 19.09.29
 */
public class CustomThreadFactoryDemoBuilder {

    private String namePrefix = null;

    private boolean daemon = false;

    private int priority = Thread.NORM_PRIORITY;

    public CustomThreadFactoryDemoBuilder setNamePrefix(String namePrefix){
        if(null == namePrefix){
            throw new NullPointerException();
        }
        this.namePrefix = namePrefix;
        return this;
    }

    public CustomThreadFactoryDemoBuilder setDeamon(boolean daemon){
        this.daemon = daemon;
        return this;
    }


    public CustomThreadFactoryDemoBuilder setPriority(int priority){
        if(priority < Thread.MIN_PRIORITY){
            throw new IllegalArgumentException(String.format("Thread priority %s >= %s", priority, Thread.MIN_PRIORITY));
        }
        if(priority > Thread.MAX_PRIORITY){
            throw new IllegalArgumentException(String.format("Thread priority %s <= %s", priority, Thread.MAX_PRIORITY));
        }
        this.priority = priority;
        return this;
    }


}
