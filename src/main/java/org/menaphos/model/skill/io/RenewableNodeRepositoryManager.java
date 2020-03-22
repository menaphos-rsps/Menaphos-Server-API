package org.menaphos.model.skill.io;

import org.menaphos.Menaphos;
import org.menaphos.model.skill.nodes.context.SkillNodeContext;
import org.menaphos.model.skill.nodes.context.impl.RenewableGatheringNodeContext;
import org.phantasye.RepositoryManager;

public class RenewableNodeRepositoryManager  extends RepositoryManager<RenewableGatheringNodeContext, RenewableNodeRepository> {

    private static RenewableNodeRepositoryManager instance = null;

    public static RenewableNodeRepositoryManager getInstance() {
        if (instance == null)
            instance = new RenewableNodeRepositoryManager();
        return instance;
    }

    private RenewableNodeRepositoryManager() {
        super(Menaphos.getInstance().getFileSystem().getBaseDirectory() +
                        Menaphos.getInstance().getFileSystem().getSeparator() +
                        "system" +
                        Menaphos.getInstance().getFileSystem().getSeparator() +
                        "repositories" +
                        Menaphos.getInstance().getFileSystem().getSeparator() +
                        "skill/renewable-node-contexts.json"
                , RenewableNodeRepository.class);
    }
}
