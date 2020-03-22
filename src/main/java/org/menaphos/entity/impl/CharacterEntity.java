package org.menaphos.entity.impl;

import org.menaphos.entity.Entity;
import org.menaphos.util.StopWatch;

public interface CharacterEntity extends Entity {

    int getId();

    boolean addItemToInventory(int id, int amount);

    boolean removeItemFromInventory(int id, int amount);

    boolean pickupItem(int id, int amount);

    void sendMessage(String msg);

    void receiveMessage(String msg);

    boolean hasItem(int id, int amount);

    void performAnimation(int animation);

    StopWatch getStopWatch();


}
