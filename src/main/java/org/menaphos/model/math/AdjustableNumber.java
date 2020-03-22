package org.menaphos.model.math;

public abstract class AdjustableNumber<N extends Number> implements Comparable<AdjustableNumber<N>> {

    protected N value;

    protected AdjustableNumber(N baseValue) {
        this.value = baseValue;
    }

    public abstract N add(N amount);

    public abstract N subtract(N amount);

    public abstract N increment();

    public abstract N decrement();

    public abstract boolean contains(N amount);

    public abstract boolean greaterThan(N number);

    public abstract boolean lessThan(N number);

    public abstract boolean equals(N number);

    public void setValue(N value) {
        this.value = value;
    }

    public N value() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
