package com.privateprojects.concurrency.threadsafe.blockingQueueExample;

/**
 * Created by Dharin on 2/9/2017.
 */
public abstract class Entry {

    boolean isDirectory = false;

    void copyTo(String path){

    }

    void moveTo(String path){

    }

    void copyTo(Entry entry){

    }

    void moveTo(Entry entry){

    }

    /* USEFUL FUNCTION */
    /*
    Stack<Entry> resolvePath(String path){

    }
    */

    abstract Entry[] listFiles();

}