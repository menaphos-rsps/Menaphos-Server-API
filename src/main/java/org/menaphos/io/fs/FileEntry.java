package org.menaphos.io.fs;

public class FileEntry {

    private final Directory parentDirectory;
    private final String name;

    public FileEntry(String name) {
        this.name = name;
        this.parentDirectory = null;
    }

    public String getName() {
        return name;
    }

    public Directory getParentDirectory() {
        return parentDirectory;
    }
}
