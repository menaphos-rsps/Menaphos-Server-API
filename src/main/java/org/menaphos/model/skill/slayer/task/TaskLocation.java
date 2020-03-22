package org.menaphos.model.skill.slayer.task;

import org.menaphos.model.world.location.Location;

public final class TaskLocation implements Comparable<TaskLocation> {

    private final int id;
    private final String name;
    private final Location location;

    public TaskLocation(int id,String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        return sb.append("ID: ").append(this.getId()).append("\n").append("Name: ").append(this.getName()).append("\n")
                .append("Location: ").append(this.getLocation()).toString();
    }

    @Override
    public int compareTo(TaskLocation o) {
        return Integer.compare(id, o.getId());
    }
}
