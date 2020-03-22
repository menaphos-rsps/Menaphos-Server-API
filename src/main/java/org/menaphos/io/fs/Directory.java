package org.menaphos.io.fs;

import java.util.ArrayList;
import java.util.List;

public class Directory {

    private final String name;
    private final boolean required;
    private final List<FileEntry> content;

    public Directory(String name, boolean required) {
        this.name = name;
        this.required = required;
        this.content = new ArrayList<>();
    }

    public Directory(String name) {
        this(name,false);
    }

    public FileEntry find(String name) {
        return content.stream().filter(fileEntry -> fileEntry.getName().equalsIgnoreCase(name)).findAny().orElseThrow(null);
    }

    public List<FileEntry> getContent() {
        return content;
    }

    public boolean isRequired() {
        return required;
    }

    public String getName() {
        return name;
    }
}
