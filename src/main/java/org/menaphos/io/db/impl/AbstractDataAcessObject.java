package org.menaphos.io.db.impl;

import org.menaphos.io.db.DataAcessObjectBase;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDataAcessObject<T> implements DataAcessObjectBase<T> {

    private final Map<Long,T> cachedEntries;
    private final DatabaseServiceProvider databaseServiceProvider;

    protected AbstractDataAcessObject(String db) {
        this.cachedEntries = new HashMap<>();
        this.databaseServiceProvider = new DatabaseServiceProvider(db);
    }

    public void saveCachedEntries() {

    }

    public DatabaseServiceProvider getDatabaseServiceProvider() {
        return databaseServiceProvider;
    }

    public Map<Long, T> getCachedEntries() {
        return cachedEntries;
    }
}
