package com.privateprojects.concurrency.threadsafe.blockingQueueExample;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Dharin on 2/9/2017.
 */

public class Indexer implements Runnable {
    private final BlockingQueue<Entry> queue;
    public Indexer(BlockingQueue<Entry> queue) {
        this.queue = queue;
    }
    public void run() {
        try {
            while (true)
                indexFile(queue.take());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void indexFile(Entry entry){
        /* add file to index here */
    }
}
