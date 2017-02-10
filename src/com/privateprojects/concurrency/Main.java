package com.privateprojects.concurrency;

import com.privateprojects.concurrency.threadsafe.DelegatingVehicleTracker;
import com.privateprojects.concurrency.threadsafe.Point;
import com.privateprojects.concurrency.threadsafe.blockingQueueExample.Entry;
import com.privateprojects.concurrency.threadsafe.blockingQueueExample.FileCrawler;
import com.privateprojects.concurrency.threadsafe.blockingQueueExample.Indexer;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    private  static  final int BOUND = 5;
    private  static  final int N_CONSUMERS = 5;

    public String className = "Main";

    public static void main(String[] args) {
	// write your code here
        DelegatingVehicleTracker d = new DelegatingVehicleTracker(new ConcurrentHashMap<String, Point>());
        d.setLocation("India", 50, 40);
        d.getLocations().remove("India");
     }

    public static void startIndexing(Entry[] roots) {
        BlockingQueue<Entry> queue = new LinkedBlockingQueue<Entry>(BOUND);
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return false;
            }
        };

        for (Entry root : roots)
            new Thread(new FileCrawler(queue, filter, root)).start();
        for (int i = 0; i < N_CONSUMERS; i++)
            new Thread(new Indexer(queue)).start();
    }
}

