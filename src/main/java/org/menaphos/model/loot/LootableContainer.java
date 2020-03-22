package org.menaphos.model.loot;


import org.menaphos.model.RandomCollection;
import org.menaphos.model.math.Range;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LootableContainer {

    private final int id;
    private final String name;
    private final List<Loot> lootList;

    protected LootableContainer(int id, String name, List<Loot> lootList) {
        this.id = id;
        this.name = name;
        this.lootList = lootList;
    }

    protected Loot roll(List<Loot> lootList) {
        final Random r = new Random();
        float chance = r.nextFloat();
        final int index = r.nextInt(lootList.size());
        if (chance <= (lootList.get(index).getPercentDrop())) {
            return lootList.get(index);
        }
        return roll(lootList);
    }

    protected float modifiedDropRate(float modifier, float dropRate) {
        return dropRate + modifier;
    }

    private Loot roll(List<Loot> lootList, double modifier) {
        final Random r = new Random();
        final float modifierPercent = (float) (modifier / 100);
        final WeightedCollection<Loot> lootWeightedCollection = new WeightedCollection<>(r);
        lootList.forEach(loot -> lootWeightedCollection.add(modifiedDropRate(modifierPercent, loot.getPercentDrop()), loot));
        final float chance = r.nextFloat();
        final Loot loot = lootWeightedCollection.next();
        final float lootRoll = Math.max(0.1f, chance - (chance * modifierPercent));
        final float roll = loot.getPercentDrop() + (loot.getPercentDrop() * modifierPercent);
        if (loot.getPercentDrop() != 1.0f) {
            if (lootRoll <= roll) {
                return loot;
            }
        }
        return roll(lootList, modifier);
    }

    protected Loot roll(double magicFind) {
        final Random random = new Random();
        final float modifierPercent = (float) (magicFind / 100);
        final RandomCollection<Loot> lootRandomCollection = this.createLootCollection(random,magicFind);
        final float roll = random.nextFloat() ;
        final Loot loot = lootRandomCollection.next();
        final float lootRoll = modifiedDropRate(modifierPercent,roll);
        if(lootRoll <= modifiedDropRate(modifierPercent,loot.getPercentDrop()))
            return loot;
        return roll(magicFind);
    }

    public Loot open(double magicFind) {
        final Loot loot = roll(magicFind);
        if (loot.getRange() != null)
            loot.getItem().getAmount().setValue(Range.getIntFromRange(loot.getRange()));
        return loot;
    }

    protected RandomCollection<Loot> createLootCollection(Random random,double magicFind) {
        final float modifierPercent = (float) (magicFind / 100);
        final RandomCollection<Loot> lootRandomCollection = new RandomCollection<>(random);
        lootList.forEach(loot -> lootRandomCollection.add(modifiedDropRate(modifierPercent, loot.getPercentDrop()), loot));
        return lootRandomCollection;
    }

    public List<Loot> receiveConstants() {
        final List<Loot> constantLoot = new ArrayList<>();
        lootList.stream()
                .filter(loot -> loot.getPercentDrop() == 1.0f)
                .filter(loot -> loot.getRange() != null)
                .forEach(loot -> loot.getItem().getAmount().setValue(Range.getIntFromRange(loot.getRange())));
        lootList.stream()
                .filter(loot -> loot.getPercentDrop() == 1.0f)
                .forEach(constantLoot::add);
        return constantLoot;
    }

//    public Loot open(double magicFind) {
//        Loot loot = roll(lootList, magicFind);
//        if (loot.getRange() != null)
//            loot.getItem().getAmount().setValue(Range.getIntFromRange(loot.getRange()));
//        return loot;
//    }

    public Loot open() {
        Loot loot = roll(lootList);
        if (loot.getRange() != null)
            loot.getItem().getAmount().setValue(Range.getIntFromRange(loot.getRange()));
        return loot;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Loot> getLoot() {
        return lootList;
    }

    @Override
    public String toString() {
        return name + " (" + id + ")";
    }
}
