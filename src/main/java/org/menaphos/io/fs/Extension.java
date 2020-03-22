package org.menaphos.io.fs;

public enum Extension {
    ZIP,PNG,JPG,JPEG,JSON;

    @Override
    public String toString() {
        return MenaphosFileSystem.FILE_PREFIX + this.name().toLowerCase();
    }
}
