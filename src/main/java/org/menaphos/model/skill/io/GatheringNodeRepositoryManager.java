package org.menaphos.model.skill.io;

import org.menaphos.Menaphos;
import org.menaphos.model.skill.nodes.context.SkillNodeContext;
import org.menaphos.model.skill.nodes.context.impl.GatheringNodeContext;
import org.phantasye.RepositoryManager;

public class GatheringNodeRepositoryManager extends RepositoryManager<GatheringNodeContext, GatheringNodeRepository> {

    private static GatheringNodeRepositoryManager instance = null;

    public static GatheringNodeRepositoryManager getInstance() {
        if (instance == null)
            instance = new GatheringNodeRepositoryManager();
        return instance;
    }

    private GatheringNodeRepositoryManager() {
        super(Menaphos.getInstance().getFileSystem().getBaseDirectory() +
                        Menaphos.getInstance().getFileSystem().getSeparator() +
                        "system" +
                        Menaphos.getInstance().getFileSystem().getSeparator() +
                        "repositories" +
                        Menaphos.getInstance().getFileSystem().getSeparator() +
                        "skill/gathering-node-contexts.json"
                , GatheringNodeRepository.class);
    }
}
