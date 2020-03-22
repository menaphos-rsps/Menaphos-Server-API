package org.menaphos.model.skill;

import org.menaphos.entity.impl.impl.PlayableCharacter;

import java.util.Arrays;

public final class SkillUtils {

    public static enum Skill {
        ATTACK,
        DEFENSE,
        STRENGTH,
        HITPOINTS,
        RANGED,
        PRAYER,
        MAGIC,
        COOKING,
        WOODCUTTING,
        FLETCHING,
        FISHING,
        FIREMAKING,
        CRAFTING,
        SMITHING,
        MINING,
        HERBLORE,
        AGILITY,
        THIEVING,
        SLAYER,
        FARMING,
        RUNECRAFTING,
        HUNTER;

        @Override
        public String toString() {
            return name().substring(0, 1).concat(name().substring(1).toLowerCase().replaceAll("_", " "));
        }
    }

    public static int getEfficiencyForLevel(PlayableCharacter player, int skillId) {
        return player.getLevelFor(skillId) * 2;
    }

    public static String getSkillName(Skill skill) {
        return skill.toString();
    }

    public static String getSkillName(int id) {
        return Arrays.stream(Skill.values()).filter(skill -> skill.ordinal() == id).findAny().orElseThrow(() -> new NullPointerException("No Skill Found")).toString();
    }

    public static int getSkillId(Skill skill) {
        return skill.ordinal();
    }
}
