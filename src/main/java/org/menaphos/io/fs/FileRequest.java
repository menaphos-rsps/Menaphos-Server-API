package org.menaphos.io.fs;

import java.io.File;
import java.util.logging.Logger;

public class FileRequest {

    private static final String LINE = "--------------------------------------------------------";

    private final Logger logger = Logger.getLogger(FileRequest.class.getName());

    private final String path;
    private final String extension;
    private final String fileName;

    private FileRequest(FileRequestBuilder bldr) {
        this.path = bldr.path.toString();
        this.extension = bldr.extension;
        this.fileName = bldr.fileName;

        logger.info(LINE + "\nFile Request created with:\n" + "Path: " + path + "\n" + "File Name: " + fileName + "\n" + "Extension: " + extension + "\n" + LINE );
    }

    public String getPath() {
        return path;
    }

    public String getFileName() {
        return fileName;
    }

    public File getFile() {
        return new File(path + fileName + (extension == null ? new String() : extension));
    }

    public String getAbsolutePath() {
        return this.getFile().getAbsolutePath();
    }

    public static class FileRequestBuilder {

        private final StringBuilder path;
        private final MenaphosFileSystem fileSystem;
        private String fileName;
        private String extension;

        public FileRequestBuilder(MenaphosFileSystem fileSystem) {
            this.path = new StringBuilder();
            this.fileSystem = fileSystem;

            path.append(fileSystem.getBaseDirectory()).append(fileSystem.getSeparator());
        }

        public FileRequestBuilder inDirectory(String directory) {
            path.append(directory).append(fileSystem.getSeparator());
            return this;
        }

        public FileRequestBuilder withExtension(String extension) {
            this.extension = extension;
            return this;
        }

        public FileRequestBuilder withExtension(Extension extension) {
            this.extension = extension.toString();
            return this;
        }

        public FileRequestBuilder withFileName(String name) {
            this.fileName = name;
            return this;
        }

        public FileRequest build() {
            return new FileRequest(this);
        }
    }

}
