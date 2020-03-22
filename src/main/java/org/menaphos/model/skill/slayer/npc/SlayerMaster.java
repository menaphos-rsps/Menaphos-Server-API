package org.menaphos.model.skill.slayer.npc;

import org.menaphos.action.ActionInvoker;
import org.menaphos.entity.impl.impl.NonPlayableCharacter;
import org.menaphos.entity.impl.impl.PlayableCharacter;
import org.menaphos.model.skill.slayer.task.SlayerTask;
import org.menaphos.model.world.location.Location;
import org.menaphos.util.StopWatch;

import java.util.List;

public class SlayerMaster implements NonPlayableCharacter, Comparable<SlayerMaster> {

    private final int npcId;
    private final int levelRequirement;
    private final int basePointValue;
    private final boolean membersOnly;
    private final List<SlayerTask> taskList;
    private final List<String> dialogOptions;

    public SlayerMaster(int npcId, int levelRequirement, int basePointValue, boolean membersOnly, List<SlayerTask> taskList, List<String> dialogOptions) {
        this.npcId = npcId;
        this.levelRequirement = levelRequirement;
        this.basePointValue = basePointValue;
        this.membersOnly = membersOnly;
        this.taskList = taskList;
        this.dialogOptions = dialogOptions;
    }

    @Override
    public void dropLootFor(PlayableCharacter player) {

    }

    @Override
    public int getId() {
        return npcId;
    }

    @Override
    public boolean addItemToInventory(int id, int amount) {
        return false;
    }

    @Override
    public boolean removeItemFromInventory(int id, int amount) {
        return false;
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

    }

    @Override
    public boolean hasItem(int id, int amount) {
        return false;
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

    @Override
    public int compareTo(SlayerMaster o) {
        return Integer.compare(npcId,o.getId());
    }

    @Override
    public String toString() {
        return String.valueOf(npcId);
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public int getBasePointValue() {
        return basePointValue;
    }

    public boolean isMembersOnly() {
        return membersOnly;
    }

    public List<String> getDialogOptions() {
        return dialogOptions;
    }

    public List<SlayerTask> getTaskList() {
        return taskList;
    }
}
