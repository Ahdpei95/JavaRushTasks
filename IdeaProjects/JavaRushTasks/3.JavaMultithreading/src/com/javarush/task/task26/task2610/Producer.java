package com.javarush.task.task26.task2610;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public Producer(ConcurrentHashMap<String, String> map) {
    }

    public void run() {

    }
}