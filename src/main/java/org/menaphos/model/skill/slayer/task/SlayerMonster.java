package org.menaphos.model.skill.slayer.task;

import java.util.List;

public class SlayerMonster implements Comparable<SlayerMonster> {

    private final int taskId;
    private final int level;
    private final String category;
    private final List<TaskLocation> locations;
    private final List<Integer> npcs;

    public SlayerMonster(int taskId,int level, String category, List<TaskLocation> locations, List<Integer> npcs) {
        this.taskId = taskId;
        this.level = level;
        this.category = category;
        this.locations = locations;
        this.npcs = npcs;
    }

    public String getCategory() {
        return category;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getLevel() {
        return level;
    }

    public List<Integer> getNpcs() {
        return npcs;
    }

    public List<TaskLocation> getLocations() {
        return locations;
    }

    @Override
    public String toString() {
        return taskId + " - " + category;
    }

    @Override
    public int compareTo(SlayerMonster o) {
        return Integer.compare(taskId,o.getTaskId());
    }
}
