package com.privateprojects.concurrency.threadsafe.blockingQueueExample2;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Dharin on 2/10/2017.
 */
public class Consumer implements Runnable{

    private BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> q){
        this.queue=q;
    }

    @Override
    public void run() {
        try{
            Message msg;
            //consuming messages until exit message is received
            while((msg = queue.take()).getMessage() !=  "exit"){
                Thread.sleep(10);
                System.out.println("Consumed "+msg.getMessage());
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
