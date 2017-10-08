package com.javarush.task.task29.task2912;

/**
 * Created by ahdpe on 04.10.2017.
 */
public abstract class AbstractLogger implements Logger {
    int level;
    Logger next;

    public void setNext(Logger next) {
        this.next = next;
    }

    public void info(String message) {
        System.out.println("Logging to file: " + message);
    }

    public void inform(String message, int level) {
        if (this.level <= level) {
            info(message);
        }
        if (next != null) {
            next.inform(message, level);
        }
    }

}
