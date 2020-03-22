package org.menaphos.model.skill;

import com.google.common.base.Preconditions;
import org.menaphos.action.impl.skill.SkillAction;
import org.menaphos.entity.impl.impl.PlayableCharacter;

public abstract class Skill {

    public static final int ATTACK = 0;
    public static final int DEFENSE = 1;
    public static final int STRENGTH = 2;
    public static final int HITPOINTS = 3;
    public static final int RANGED = 4;
    public static final int PRAYER = 5;
    public static final int MAGIC = 6;
    public static final int COOKING = 7;
    public static final int WOODCUTTING = 8;
    public static final int FLETCHING = 9;
    public static final int FISHING = 10;
    public static final int FIREMAKING = 11;
    public static final int CRAFTING = 12;
    public static final int SMITHING = 13;
    public static final int MINING = 14;
    public static final int HERBLORE = 15;
    public static final int AGILITY = 16;
    public static final int THIEVING = 17;
    public static final int SLAYER = 18;
    public static final int FARMING = 19;
    public static final int RUNECRAFTING = 20;
    public static final int HUNTER = 21;

    private final PlayableCharacter player;

    protected Skill(PlayableCharacter player) {
        this.player = player;
    }

    public abstract void perform(SkillAction action) throws IllegalArgumentException;

    protected void defaultLevelCheckPrecondition(int skill, int level) {
        Preconditions.checkArgument(this.hasLevel(skill,level),"You need a " + SkillUtils.getSkillName(skill) + " level of at least " + level + " to do that.");
    }

    protected boolean hasLevel(int id, int level) {
        return player.getLevelFor(id) >= level;
    }

    protected double getXPMultiplier() {
        return 1.5;
    }

    public PlayableCharacter getPlayer() {
        return player;
    }
}
