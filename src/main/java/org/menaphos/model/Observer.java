package org.menaphos.model;

import org.menaphos.log.EventLog;

public interface Observer {

    void update(EventLog log);
}
