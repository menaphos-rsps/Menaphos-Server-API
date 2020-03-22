package org.menaphos.action.impl.skill.gathering;

import com.google.common.base.Stopwatch;
import org.menaphos.entity.impl.impl.PlayableCharacter;
import org.menaphos.model.loot.Loot;
import org.menaphos.model.skill.Skill;
import org.menaphos.model.skill.SkillUtils;
import org.menaphos.model.skill.item.tool.GatheringTool;
import org.menaphos.model.skill.nodes.context.impl.RenewableGatheringNodeContext;
import org.menaphos.model.skill.nodes.context.impl.test.OreNode;
import org.menaphos.model.world.location.Location;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MiningAction extends GatheringSkillAction {

    private final OreNode ore;
    private final GatheringTool tool;

    public MiningAction(RenewableGatheringNodeContext context, GatheringSkillActionContext actionContext) {
        super(actionContext,context);
        this.ore = new OreNode(context,actionContext.getNodeLocation());
        this.tool = actionContext.getGatheringTool();
    }

    @Override
    public boolean invoke() {
        final Stopwatch stopwatch = Stopwatch.createStarted();
        this.getActor().receiveMessage(ore.getAttemptMessage());
        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                getActor().performAnimation(getActionContext().getGatheringTool().getAnimation());
                final Loot loot = ore.open(tool.getEfficiency() + SkillUtils.getEfficiencyForLevel(getActionContext().getActor(),Skill.MINING));
                if(loot != null) {
                    getActor().addItemToInventory(loot.getItem().getId(),loot.getItem().getAmount().value());
                    getActor().receiveMessage(ore.getOpenMessage());
                    System.out.println("ELAPSED TIME: " + stopwatch.stop().elapsed(TimeUnit.SECONDS) + " SECONDS");
                    timer.cancel();
                }
            }
        };

        timer.scheduleAtFixedRate(timerTask,600,600);
        return false;
    }

    @Override
    public RenewableGatheringNodeContext getContext() {
        return (RenewableGatheringNodeContext) super.getContext();
    }
}
