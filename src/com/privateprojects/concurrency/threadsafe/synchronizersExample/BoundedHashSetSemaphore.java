package com.privateprojects.concurrency.threadsafe.synchronizersExample;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Created by Dharin on 2/10/2017.
 */
public class BoundedHashSetSemaphore<T> {
    private final Set<T> set;
    private final Semaphore sem;

    public BoundedHashSetSemaphore(int bound){
        this.sem = new Semaphore(bound);
        this.set = Collections.synchronizedSet(new HashSet<T>());
    }

    public boolean add(T o) throws InterruptedException{
        sem.acquire();
        boolean wasAdded = false;
        try{
            wasAdded = set.add(o);
            return wasAdded;
        }finally {
            if(!wasAdded){
                sem.release();
            }
        }
    }

    public boolean remove(Object o) {
        boolean wasRemoved = set.remove(o);
        if (wasRemoved)
            sem.release();
        return wasRemoved;
    }
}
