package org.menaphos.model.skill.slayer.task;

import org.menaphos.model.math.Range;

public class SlayerTask implements Comparable<SlayerTask>{

    private final int taskId;
    private final Range amount;
    private final Range extendedAmount;
    private int weight;

    public SlayerTask(int taskId, Range amount, Range extendedAmount, int weight) {
        this.taskId = taskId;
        this.amount = amount;
        this.extendedAmount = extendedAmount;
        this.weight = weight;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getWeight() {
        return weight;
    }

    public Range getAmount() {
        return amount;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Range getExtendedAmount() {
        return extendedAmount;
    }

    @Override
    public int compareTo(SlayerTask o) {
        return Integer.compare(taskId,o.taskId);
    }

    @Override
    public String toString() {
        return String.valueOf(taskId);
    }
}
