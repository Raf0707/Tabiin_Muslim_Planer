package com.example.tabiin.util;

public class Timer extends Thread {
    private Runnable task;
    private int time;

    public void setTask(Runnable task) {
        this.task = task;
    }

    public Runnable getTask() {
        return task;
    }

    public int getTime() {
        return time;
    }

    void runTimer(int time){
        this.time = time;
        start();
    }

    @Override
    public void run() {
        while (time > 0){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time--;
        }
        task.run();
    }

    @Override
    public String toString() {
        int hours = time / 3600;
        int minutes = (time % 3600) / 60;
        int seconds = time % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}