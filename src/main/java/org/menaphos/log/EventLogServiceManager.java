package org.menaphos.log;

import org.phantasye.RepositoryManager;

import java.util.*;

public final class EventLogServiceManager  {

    private static EventLogServiceManager instance = null;

    public static EventLogServiceManager getInstance() {
        if(instance == null)
            instance = new EventLogServiceManager();
        return instance;
    }

    public String generateUUID() {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        return randomUUIDString;
    }

    public void storeLog(EventLog log) {
        eventLogList.add(log);
        if(eventLogList.size() % 10 == 0) {
            this.batchSaveLogs();
        }
    }

    private void batchSaveLogs() {
        final RepositoryManager<EventLog,EventLogRepository> manager =
                new EventLogRepositoryManager();

        eventLogList.forEach(log -> manager.getRepository().create(log));
        manager.updateRepository();
    }

    private EventLogServiceManager() {
        this.eventLogList = new ArrayList<>();
    }

    private final List<EventLog> eventLogList;
}
