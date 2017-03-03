package com.privateprojects.concurrency.threadsafe.PrintInOrder;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by Dharin on 3/3/2017.
 */
public class OddRunnable implements Runnable{
    public int i = 1;
    private PriorityBlockingQueue<Integer> queue;

    public OddRunnable(PriorityBlockingQueue<Integer> queue){
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



