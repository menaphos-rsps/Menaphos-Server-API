package org.menaphos.io.fs.repository;

import org.menaphos.Menaphos;
import org.menaphos.model.skill.slayer.task.TaskLocation;
import org.phantasye.RepositoryManager;

public class TaskLocationRepositoryManager extends RepositoryManager<TaskLocation,TaskLocationRepository> {

    private static TaskLocationRepositoryManager instance = null;

    public static TaskLocationRepositoryManager getInstance() {
        if (instance == null)
            instance = new TaskLocationRepositoryManager();
        return instance;
    }

    private TaskLocationRepositoryManager() {
        super(Menaphos.getInstance().requestRepository(Menaphos.Repository.TASK_LOCATION).getAbsolutePath(), TaskLocationRepository.class);
    }
}
