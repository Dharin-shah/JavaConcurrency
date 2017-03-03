package com.privateprojects.concurrency.threadsafe.PrintInOrder;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by Dharin on 3/3/2017.
 */
public class EvenRunnable implements Runnable{
    private int i = 0;
    private PriorityBlockingQueue<Integer> queue;

    public EvenRunnable(PriorityBlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while(i < 100){
            queue.add(i);
            i = i + 2;
        }
    }
}

