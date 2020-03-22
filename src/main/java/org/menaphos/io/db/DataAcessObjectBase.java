package org.menaphos.io.db;

import java.util.List;
import java.util.logging.Logger;

public interface DataAcessObjectBase<T> {

    Logger LOG = Logger.getLogger(DataAcessObjectBase.class.getSimpleName());

    List<T> getAllEntries();

    void update(T t);

    void create(T t);

    void delete(T t);

    T read(T t);

    T read(long id);
}
