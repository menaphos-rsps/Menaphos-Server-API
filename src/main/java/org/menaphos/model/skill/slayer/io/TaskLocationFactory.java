package org.menaphos.model.skill.slayer.io;

import org.menaphos.io.fs.repository.TaskLocationRepositoryManager;
import org.menaphos.model.skill.slayer.task.TaskLocation;

import java.util.HashMap;
import java.util.Map;

public final class TaskLocationFactory {

    private final static Map<Integer, TaskLocation> taskLocationMap = new HashMap<>();

    public static TaskLocation getTaskLocation(int id) {
        TaskLocation taskLocation = taskLocationMap.get(id);

        if (taskLocation == null)
            taskLocation = TaskLocationRepositoryManager.getInstance().getRepository().readByKey(String.valueOf(id));
        taskLocationMap.putIfAbsent(id,taskLocation);
        return taskLocation;
    }
}
