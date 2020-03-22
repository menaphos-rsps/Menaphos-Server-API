package org.menaphos.model.skill.nodes.context.impl.test;

import org.menaphos.model.RandomCollection;
import org.menaphos.model.loot.Loot;
import org.menaphos.model.loot.LootableContainer;
import org.menaphos.model.loot.LootableObject;
import org.menaphos.model.loot.factory.LootFactory;
import org.menaphos.model.math.Range;
import org.menaphos.model.skill.nodes.context.ReplishableNode;
import org.menaphos.model.skill.nodes.context.impl.RenewableGatheringNodeContext;
import org.menaphos.model.world.location.Location;

import java.util.List;
import java.util.Random;

public class OreNode extends LootableObject implements ReplishableNode {

    private final Location location;
    private final RenewableGatheringNodeContext context;

    public OreNode(RenewableGatheringNodeContext context, Location location) {
        super(
                context.getObjectId(),
                LootFactory.getLootableObject(context.getObjectId()).getName(),
                LootFactory.getLootableObject(context.getObjectId()).getLoot(),
                LootFactory.getLootableObject(context.getObjectId()).getKeyId(),
                LootFactory.getLootableObject(context.getObjectId()).getKeyQty(),
                LootFactory.getLootableObject(context.getObjectId()).getOpenMessage(),
                LootFactory.getLootableObject(context.getObjectId()).getAttemptMessage(),
                LootFactory.getLootableObject(context.getObjectId()).getAnimationId());
        this.location = location;
        this.context = context;
    }

    @Override
    protected Loot roll(double magicFind) {
        final Random random = new Random();
        final float modifierPercent = (float) (magicFind / 100);
        final RandomCollection<Loot> lootRandomCollection = this.createLootCollection(random,magicFind);
        final Loot loot = lootRandomCollection.next();
        final float lootRoll = loot.getPercentDrop() * random.nextFloat();
        final float playerRoll = random.nextFloat() / modifierPercent;
//
//        System.out.println("LOOT ROLL: " + lootRoll);
//        System.out.println("PLAYER ROLL: " + playerRoll);
//        System.out.println("----------------------------------");

        if(playerRoll <= lootRoll)
            return loot;
        return null;
    }

    @Override
    public Loot open(double magicFind) {
        return roll(magicFind);
    }

    @Override
    public void respawn() {
        System.out.println("RESPAWN");
    }

    @Override
    public void despawn() {
        System.out.println("DESPAWN");
    }

    public Location getLocation() {
        return location;
    }

    public RenewableGatheringNodeContext getContext() {
        return context;
    }
}
