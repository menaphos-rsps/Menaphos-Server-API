package org.menaphos.model.world.location.region;

import org.menaphos.model.world.location.Location;

public class Region implements Comparable<Region> {

    private final Location southWestCorner;
    private final Location northEastCorner;

    public Region(Location southWestCorner, Location northEastCorner) {
        this.southWestCorner = southWestCorner;
        this.northEastCorner = northEastCorner;
    }

    public Location getNorthEastCorner() {
        return northEastCorner;
    }

    public Location getSouthWestCorner() {
        return southWestCorner;
    }

    public int getWidth() {
        return northEastCorner.getXCoordinate() - southWestCorner.getXCoordinate();
    }

    public int getLength() {
        return northEastCorner.getZCoordinate() - southWestCorner.getZCoordinate();
    }

    public int getHeight() {
        return northEastCorner.getYCoordinate() - southWestCorner.getYCoordinate();
    }

    public boolean contains(Location location) {
        int x0 = southWestCorner.getXCoordinate();
        int z0 = southWestCorner.getZCoordinate();
        int y0 = southWestCorner.getYCoordinate();
        return (location.getXCoordinate() >= x0 &&
                location.getZCoordinate() >= z0 &&
                location.getYCoordinate() >= y0 &&
                location.getYCoordinate() <= y0 + getHeight() &&
                location.getXCoordinate() <= x0 + getWidth() &&
                location.getZCoordinate() <= z0 + getLength());
    }

    public boolean intersects(Region region) {
        return this.compareTo(region) != 0;
    }


    @Override
    public int compareTo(Region o) {
        return this.contains(o.southWestCorner) ? 1 : this.contains(o.northEastCorner) ? -1 : 0;
    }
}
