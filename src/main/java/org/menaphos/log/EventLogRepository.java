package org.menaphos.log;

import org.phantasye.AbstractJsonRepository;

public class EventLogRepository extends AbstractJsonRepository<EventLog> {
    @Override
    public void create(EventLog log) {
        entries.put(log.getUuid(),log);
    }

    @Override
    public EventLog read(EventLog log) {
        return entries.get(log.getUuid());
    }

    @Override
    public void delete(EventLog log) {
        entries.remove(log.getUuid());
    }
}
