package org.menaphos.model.skill.io;

import org.menaphos.Menaphos;
import org.menaphos.model.skill.nodes.context.SkillNodeContext;
import org.phantasye.RepositoryManager;

public class SkillNodeRepositoryManager extends RepositoryManager<SkillNodeContext, SkillNodeContextRepository> {

    private static SkillNodeRepositoryManager instance = null;

    public static SkillNodeRepositoryManager getInstance() {
        if(instance == null)
            instance = new SkillNodeRepositoryManager();
        return instance;
    }

    private SkillNodeRepositoryManager() {
        super(Menaphos.getInstance().getFileSystem().getBaseDirectory() +
                        Menaphos.getInstance().getFileSystem().getSeparator() +
                        "system" +
                        Menaphos.getInstance().getFileSystem().getSeparator() +
                        "repositories" +
                        Menaphos.getInstance().getFileSystem().getSeparator() +
                        "skill/node-contexts.json"
                , SkillNodeContextRepository.class);
    }
}
