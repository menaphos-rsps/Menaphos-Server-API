package org.menaphos.model.math.impl;

import org.menaphos.model.math.AdjustableNumber;

public class AdjustableInteger extends AdjustableNumber<Integer> {

    public AdjustableInteger(Integer baseValue) {
        super(baseValue);
    }

    @Override
    public Integer add(Integer amount) {
        value += amount;
        return value;
    }

    @Override
    public Integer subtract(Integer amount) {
        value -= amount;
        return value;
    }

    @Override
    public Integer increment() {
        value++;
        return value;
    }

    @Override
    public Integer decrement() {
        value--;
        return value;
    }

    @Override
    public boolean contains(Integer amount) {
       return value >= amount;
    }

    @Override
    public boolean greaterThan(Integer number) {
        return value > number;
    }

    @Override
    public boolean lessThan(Integer number) {
        return value < number;
    }

    @Override
    public boolean equals(Integer number) {
        return value == number;
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public int compareTo(AdjustableNumber<Integer> o) {
        return value.compareTo(o.value());
    }
}
