package org.menaphos.log;

public interface EventLogService  {

    default void log(EventLog log) {
        EventLogServiceManager.getInstance().storeLog(log);
    }
}
