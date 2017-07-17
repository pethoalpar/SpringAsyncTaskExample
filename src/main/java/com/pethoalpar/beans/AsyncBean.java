package com.pethoalpar.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by petho on 2017-07-17.
 */
@Component
public class AsyncBean {

    @Autowired
    private Location location;

    @Async
    public void runAsyncTask(String name, long sleepTime){
        System.out.println("Start running:"+name+" on location:"+location.getLocation());
        try {
            Thread.sleep(sleepTime);
            System.out.println("End running:"+name+" on location:"+location.getLocation());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
