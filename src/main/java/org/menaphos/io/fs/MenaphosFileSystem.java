package org.menaphos.io.fs;

import java.io.File;
import java.nio.file.FileSystems;

public interface MenaphosFileSystem {

    public static final char FILE_PREFIX = '.';

    default String getSeparator() {
        return FileSystems.getDefault().getSeparator();
    }

    default String getBaseDirectory() {
        return System.getProperty("user.home") + FileSystems.getDefault().getSeparator() + ".menaphos";
    }

    void create(FileRequest fileRequest);

    File read(FileRequest fileRequest);

    void update(FileRequest fileRequest);

    void delete(FileRequest fileRequest);

    void patch(FileRequest fileRequest);

    boolean init();
}
