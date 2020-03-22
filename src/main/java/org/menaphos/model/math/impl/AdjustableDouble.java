package org.menaphos.model.math.impl;

import org.menaphos.model.math.AdjustableNumber;

public class AdjustableDouble extends AdjustableNumber<Double> {

    public AdjustableDouble(Double baseValue) {
        super(baseValue);
    }

    @Override
    public Double add(Double amount) {
        value += amount;
        return value;
    }

    @Override
    public Double subtract(Double amount) {
        value -= amount;
        return value;
    }

    @Override
    public Double increment() {
        value++;
        return value;
    }

    @Override
    public Double decrement() {
        value--;
        return value;
    }

    @Override
    public boolean contains(Double amount) {
        return value >= amount;
    }

    @Override
    public boolean greaterThan(Double number) {
        return value > number;
    }

    @Override
    public boolean lessThan(Double number) {
        return value < number;
    }

    @Override
    public boolean equals(Double number) {
        return value == number;
    }

    @Override
    public Double value() {
        return value;
    }

    @Override
    public int compareTo(AdjustableNumber<Double> o) {
        return value.compareTo(o.value());
    }
}
