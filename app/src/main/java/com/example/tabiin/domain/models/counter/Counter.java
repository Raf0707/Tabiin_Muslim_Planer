package com.example.tabiin.domain.models.counter;

public class Counter {
    private String title;
    private String description;
    private int aim;
    private int currentProgress;
    private CounterState counterState;


    public Counter(String title, String description, int aim, int currentProgress) {
        this.title = title;
        this.description = description;
        this.aim = aim;
        this.currentProgress = currentProgress;
        this.counterState = CounterState.NOTCOMPLETE;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAim() {
        return aim;
    }

    public void setAim(int aim) {
        this.aim = aim;
    }

    public int getCurrentProgress() {
        return currentProgress;
    }

    public void setCurrentProgress(int currentProgress) {
        this.currentProgress = currentProgress;
    }

    public CounterState getCounterState() {
        return counterState;
    }

    public void setCounterState(CounterState counterState) {
        this.counterState = counterState;
    }

}
