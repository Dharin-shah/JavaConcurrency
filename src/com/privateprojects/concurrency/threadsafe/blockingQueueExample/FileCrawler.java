package com.privateprojects.concurrency.threadsafe.blockingQueueExample;

import java.io.*;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Dharin on 2/8/2017.
 */
public class FileCrawler implements Runnable{
    private final BlockingQueue<Entry> fileQueue;
    private final FileFilter fileFilter;
    private final Entry root;

    public FileCrawler(BlockingQueue<Entry> fileQueue, FileFilter fileFilter, Entry root){
        this.fileQueue = fileQueue;
        this.fileFilter = fileFilter;
        this.root = root;
    }

    public void run() {
        try {
            crawl(root);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    private void crawl(Entry root) throws InterruptedException {
        Entry[] entries = root.listFiles();
        if (entries != null) {
            for (Entry entry : entries)
                if (entry.isDirectory)
                    crawl(entry);
                else if (!alreadyIndexed(entry))
                    fileQueue.put(entry);
        }
    }

    /* a test implementation */
    private boolean alreadyIndexed(Entry entry){
        return false;
    }

}
