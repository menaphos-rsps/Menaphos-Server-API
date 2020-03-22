package org.menaphos.util;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public final class StopWatch {

    private final Stopwatch stopwatch;

    public StopWatch() {
        this.stopwatch = Stopwatch.createStarted();
    }

    public void start() {
        if (!stopwatch.isRunning())
            stopwatch.start();
    }

    public void stop() {
        if (stopwatch.isRunning())
            stopwatch.stop();
    }

    public long getElapsedTime(TimeUnit timeUnit) {
        return stopwatch.elapsed(timeUnit);
    }

    public long getElapsedMS() {
        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    public void reset() {
        stopwatch.reset();
    }


}
