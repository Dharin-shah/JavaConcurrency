package com.privateprojects.concurrency.threadsafe;

/**
 * Created by Dharin on 2/7/2017.
 */
public class SequenceCounter {
     private int value;

    /* THREAD SAFE*/
    /* threads need to acquire the intrinsic lock of self before executing this function*/
    public synchronized int getNext(){
        return value++;
    }
}
