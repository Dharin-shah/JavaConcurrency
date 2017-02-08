package com.privateprojects.concurrency.threadsafe;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dharin on 2/8/2017.
 */
public class DelegatingVehicleTracker {

    private final ConcurrentHashMap<String, Point> locations;
    private final Map<String, Point> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, Point> points){
        locations = new ConcurrentHashMap<String, Point>(points);
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, Point> getLocations(){
        return unmodifiableMap;
    }

    public Point getLocation(String id){
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        locations.put(id, new Point(x,y));
        if (locations.replace(id, new Point(x, y)) == null) {
            throw new IllegalArgumentException("invalid vehicle name");
        }
    }
}

