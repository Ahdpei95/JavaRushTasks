package com.javarush.task.task25.task2506;


public class LoggingStateThread extends Thread {
    private Thread thread;
    private State state = null;
    public LoggingStateThread (Thread thread){
        this.thread = thread;
        this.setDaemon(true);
    }

    public void run(){

        while (true){
            State state = thread.getState();
            if (this.state == null) {
                this.state = state;
                System.out.println(state.toString());
            } else if (!state.equals(this.state)) {
                System.out.println(state.toString());
                this.state = state;
            }
            if (state.equals(State.TERMINATED)) { break; }

        }
    }
}
