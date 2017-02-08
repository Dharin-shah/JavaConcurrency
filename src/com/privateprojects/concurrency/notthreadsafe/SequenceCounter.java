package com.privateprojects.concurrency.notthreadsafe;

/**
 * Created by Dharin on 2/7/2017.
 */

public class SequenceCounter {
    private int value;

    /*NOT THREAD SAFE*/
    /*May happen two threads access this simultaneously and get the same value*/
    public int getNext(){
        //not atomic either
        return value++;
    }
}
