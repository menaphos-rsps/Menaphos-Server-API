package org.menaphos.model.skill.slayer;

public class SlayerUnlock implements Comparable<SlayerUnlock> {

    private final int id;
    private final String name;
    private final int cost;
    private final String description;

    public SlayerUnlock(int id, String name, int cost, String description) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(SlayerUnlock o) {
        return Integer.compare(id,o.getId());
    }

    @Override
    public String toString() {
        return name;
    }
}
