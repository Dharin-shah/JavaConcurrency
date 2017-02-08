package com.privateprojects.concurrency.threadsafe.blockingQueueExample;

/**
 * Created by Dharin on 2/8/2017.
 */

public class Directory extends Entry{
    private final Entry[] files;

    public Directory(File[] files){
        this.files = files;
        super.isDirectory = true;
    }

    @Override
    Entry[] listFiles() {
        return files;
    }
}
