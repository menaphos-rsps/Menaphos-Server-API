package org.menaphos.entity.impl.impl;

import org.menaphos.action.ActionInvoker;
import org.menaphos.entity.impl.item.container.ItemContainer;
import org.menaphos.entity.impl.item.container.impl.DefaultItemContainerImpl;
import org.menaphos.model.loot.Loot;
import org.menaphos.model.world.location.Location;
import org.menaphos.util.StopWatch;

public class MockPlayer implements PlayableCharacter {

    private final ItemContainer inventory;

    public MockPlayer() {
        this.inventory = new DefaultItemContainerImpl(28);
    }

    @Override
    public int getRights() {
        return 0;
    }

    @Override
    public double getMagicFind() {
        return 0;
    }

    @Override
    public int getLevelFor(int skill) {
        return 99;
    }

    @Override
    public void receiveDropFrom(NonPlayableCharacter npc, Loot loot, Location dropLocation) {

    }

    @Override
    public void register() {

    }

    @Override
    public void deregister() {

    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public boolean addItemToInventory(int id, int amount) {
        return inventory.add(id,amount);
    }

    @Override
    public boolean removeItemFromInventory(int id, int amount) {
        return inventory.remove(id,amount);
    }

    @Override
    public boolean pickupItem(int id, int amount) {
        return false;
    }

    @Override
    public void sendMessage(String msg) {

    }

    @Override
    public void receiveMessage(String msg) {
        System.out.println("PLAYER: " + msg);
    }

    @Override
    public boolean hasItem(int id, int amount) {
        return inventory.contains(id) && inventory.count(id) >= amount;
    }

    @Override
    public void performAnimation(int animation) {

    }

    @Override
    public StopWatch getStopWatch() {
        return null;
    }

    @Override
    public ActionInvoker getActionInvoker() {
        return null;
    }

    @Override
    public boolean moveTo(Location location) {
        return false;
    }

    public ItemContainer getInventory() {
        return inventory;
    }
}
