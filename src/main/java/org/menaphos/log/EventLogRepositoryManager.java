package org.menaphos.log;

import org.menaphos.Menaphos;
import org.phantasye.RepositoryManager;

public final class EventLogRepositoryManager extends RepositoryManager<EventLog,EventLogRepository> {

    public EventLogRepositoryManager() {
        super(Menaphos.getInstance().requestRepository(Menaphos.Repository.LOGGING).getAbsolutePath(), EventLogRepository.class);
    }
}
