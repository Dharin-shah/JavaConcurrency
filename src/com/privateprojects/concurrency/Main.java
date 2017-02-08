package com.privateprojects.concurrency;

import com.privateprojects.concurrency.threadsafe.*;
import com.privateprojects.concurrency.threadsafe.Point;

import java.util.Map;

import java.awt.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public String className = "Main";
    public static void main(String[] args) {
	// write your code here
        DelegatingVehicleTracker d = new DelegatingVehicleTracker(new ConcurrentHashMap<String, Point>());
        d.setLocation("India", 50, 40);
        d.getLocations().remove("India");
     }
}

