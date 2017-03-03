package com.privateprojects.concurrency;

import com.privateprojects.concurrency.threadsafe.DelegatingVehicleTracker;
import com.privateprojects.concurrency.threadsafe.Point;
import com.privateprojects.concurrency.threadsafe.PrintInOrder.EvenRunnable;
import com.privateprojects.concurrency.threadsafe.PrintInOrder.OddRunnable;
import com.privateprojects.concurrency.threadsafe.blockingQueueExample.Entry;
import com.privateprojects.concurrency.threadsafe.blockingQueueExample.FileCrawler;
import com.privateprojects.concurrency.threadsafe.blockingQueueExample.Indexer;

import java.io.File;
import java.io.FileFilter;
import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    private  static  final int BOUND = 5;
    private  static  final int N_CONSUMERS = 5;

    public String className = "Main";

    public static void main(String[] args) throws Exception{ //bad way to handle
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<Integer>(100, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2) return -1;
                else return 1;
            }
        });

        new Thread(new OddRunnable(queue)).start();
        new Thread(new EvenRunnable(queue)).start();

        while (queue.iterator().hasNext()){
            System.out.println(queue.take());
        }
    }

        /*
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
    }*/
}

