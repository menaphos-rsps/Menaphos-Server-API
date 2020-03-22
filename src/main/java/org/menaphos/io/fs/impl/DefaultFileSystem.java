package org.menaphos.io.fs.impl;

import org.menaphos.io.cache.CrunchifyInMemoryCache;
import org.menaphos.io.fs.FileRequest;
import org.menaphos.io.fs.MenaphosFileSystem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DefaultFileSystem implements MenaphosFileSystem {

    public static final String SERVER = ".server";
    public static final String DATA = "data";
    public static final String REPOSITORY = "repositories";

    private final List<File> requiredFileList;
    private final CrunchifyInMemoryCache<String, File> cache;
    private final Logger logger = Logger.getLogger(DefaultFileSystem.class.getSimpleName());

    public DefaultFileSystem(CrunchifyInMemoryCache cache) {
        this.requiredFileList = new ArrayList<>();
        this.cache = cache;

        this.requiredFileList.add(new FileRequest.FileRequestBuilder(this)
                .inDirectory(SERVER)
                .inDirectory(DATA)
                .withFileName(REPOSITORY)
                .build()
                .getFile());

        this.requiredFileList.add(new FileRequest.FileRequestBuilder(this)
                .inDirectory("system")
                .withFileName(REPOSITORY)
                .build()
                .getFile());

        this.requiredFileList.add(new FileRequest.FileRequestBuilder(this)
                .inDirectory("system")
                .inDirectory(REPOSITORY)
                .withFileName("skill")
                .build()
                .getFile());
    }


    @Override
    public void create(FileRequest fileRequest) {
        cache.put(fileRequest.getPath(), new File(fileRequest.getPath()));
    }

    @Override
    public File read(FileRequest fileRequest) {
        return cache.get(fileRequest.getPath());
    }

    @Override
    public void update(FileRequest fileRequest) {

    }

    @Override
    public void delete(FileRequest fileRequest) {
        cache.remove(fileRequest.getPath());
    }

    @Override
    public void patch(FileRequest fileRequest) {
        final File file = new File(fileRequest.getAbsolutePath());
        if (!file.exists()) {
//            Arrays.stream(Menaphos.Repository.values())
//                    .filter(repository -> repository.getFileName().equalsIgnoreCase(fileRequest.getFileName()))
//                    .forEach(missing ->Objects.requireNonNull(Menaphos.getRepositoryManagerFor(missing)).createRepository());
        } else {
            logger.info("Patch Found: " + fileRequest.getFileName());
        }
    }

    @Override
    public boolean init() {
        List<Boolean> requiredFiles = new ArrayList<>();
//        requiredFileList.stream().filter(File::mkdirs).forEach(requiredFile -> System.out.println(requiredFile.getAbsolutePath() + " - " +requiredFile.mkdirs()));
        requiredFileList.stream().filter(File::mkdirs).forEach(requiredFile -> requiredFiles.add(!requiredFile.mkdirs()));
        requiredFileList.stream().filter(file -> !file.isDirectory()).forEach(f -> requiredFiles.add(f.exists()));
        return requiredFiles.contains(false);
    }
}
