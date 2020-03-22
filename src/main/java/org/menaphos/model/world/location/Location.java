package org.menaphos.model.world.location;

import org.menaphos.model.math.AdjustableNumber;
import org.menaphos.util.MathUtils;
import org.menaphos.model.math.impl.AdjustableInteger;

public final class Location implements Comparable<Location>, Cloneable {

    public static final int GROUND_LEVEL = 0;

    private AdjustableInteger x;
    private AdjustableInteger z;
    private AdjustableInteger y;

    public Location(int x, int y, int z) {
        this.x = new AdjustableInteger(x);
        this.y = new AdjustableInteger(y);
        this.z = new AdjustableInteger(z);
    }

    public Location(int x, int z) {
        this(x, GROUND_LEVEL, z);
    }

    public int getZCoordinate() {
        return z.value();
    }

    public int getYCoordinate() {
        return y.value();
    }

    public int getXCoordinate() {
        return x.value();
    }

    public AdjustableNumber<Integer> getX() {
        return x;
    }

    public AdjustableNumber<Integer> getY() {
        return y;
    }

    public AdjustableNumber<Integer> getZ() {
        return z;
    }

    public void copy(Location target) {
        this.x.setValue(target.x.value());
        this.y.setValue(target.y.value());
        this.z.setValue(target.z.value());
    }

    public void translate(Face face) {
        switch (face) {
            case NORTH:
                z.increment();
                break;
            case NORTHEAST:
                z.increment();
                x.increment();
                break;
            case EAST:
                x.increment();
                break;
            case SOUTHEAST:
                z.decrement();
                x.increment();
                break;
            case SOUTH:
                z.decrement();
                break;
            case SOUTHWEST:
                z.decrement();
                x.decrement();
                break;
            case WEST:
                x.decrement();
                break;
            case NORTHWEST:
                z.increment();
                x.decrement();
                break;
        }
    }

    public Face directionFrom(Location target) {
        final double y = MathUtils.difference(target.getZCoordinate(), this.getZCoordinate());
        final double x = MathUtils.difference(target.getXCoordinate(), this.getXCoordinate());
        final double theta = MathUtils.theta(y, x);
        final double angle = MathUtils.angle(theta);
        if (angle == 180) {
            return Face.WEST;
        } else if (angle == 0) {
            return Face.EAST;
        } else if(angle == 90) {
            return Face.NORTH;
        } else if(angle == -90) {
            return Face.SOUTH;
        } else if(angle < 0 && angle > -90) {
            return Face.SOUTHEAST;
        } else if(angle < -90 && angle > -180) {
            return Face.SOUTHWEST;
        } else if(angle > 90 && angle < 180) {
            return Face.NORTHWEST;
        } else {
            return Face.NORTHEAST;
        }
    }

    public int distanceFrom(Location location) {
        int deltaX = x.subtract(location.x.value());
        int deltaZ = z.subtract(location.z.value());
        return (int) Math.ceil(Math.sqrt(deltaX * deltaX + deltaZ * deltaZ));
    }

    public boolean matches(Location location) {
        return compareTo(location) == 0;
    }

    @Override
    public int compareTo(Location o) {
        if (x.compareTo(o.x) + z.compareTo(o.z) + y.compareTo(o.y) == 0)
            return 0;
        return -1;
    }

    @Override
    public String toString() {
        return "[X=" + x + " | Y=" + y + " | Z=" + z + " ]";
    }

    @Override
    public Location clone() {
        return this;
    }
}
