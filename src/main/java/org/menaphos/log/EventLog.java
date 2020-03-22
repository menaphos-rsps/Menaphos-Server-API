package org.menaphos.log;

import java.time.LocalDateTime;

public final class EventLog  {

    private final String uuid;
    private final int id;
    private final String title;
    private final String info;
    private final LocalDateTime timestamp;

    private EventLog(EventLogWriter writer) {
        this.uuid = EventLogServiceManager.getInstance().generateUUID();
        this.id = writer.id;
        this.title = writer.title;
        this.info = writer.stringBuilder.toString();
        this.timestamp = LocalDateTime.now();
    }

    public String getUuid() {
        return uuid;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getInfo() {
        return info;
    }

    public static class EventLogWriter {

        private final int id;
        private final String title;
        private StringBuilder stringBuilder;

        public EventLogWriter(int id, String title) {
            this.id = id;
            this.title = title;
            this.stringBuilder = new StringBuilder();
        }

        public EventLogWriter writeLine(String line) {
            stringBuilder.append(line).append("\n");
            return this;
        }

        public EventLog write() {
            return new EventLog(this);
        }

    }

}
