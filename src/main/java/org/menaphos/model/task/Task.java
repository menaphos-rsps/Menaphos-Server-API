package org.menaphos.model.task;

public abstract class Task implements Runnable {

    private final long period;
    private final long delay;

    protected Task(long period, long delay) {
        this.period = period;
        this.delay = delay;
    }

    protected Task(long period) {
        this(period,period);
    }

    public long getDelay() {
        return delay;
    }

    public long getPeriod() {
        return period;
    }
}
