package org.menaphos.io.fs.repository;

import org.menaphos.model.skill.slayer.task.TaskLocation;
import org.phantasye.AbstractJsonRepository;

public class TaskLocationRepository extends AbstractJsonRepository<TaskLocation> {
    @Override
    public void create(TaskLocation taskLocation) {
        entries.put(String.valueOf(taskLocation.getId()),taskLocation);
    }

    @Override
    public TaskLocation read(TaskLocation taskLocation) {
        return entries.get(String.valueOf(taskLocation.getId()));
    }

    @Override
    public void delete(TaskLocation taskLocation) {
        entries.remove(String.valueOf(taskLocation.getId()));
    }
}
