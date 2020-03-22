package org.menaphos.io.fs.repository;

import org.menaphos.Menaphos;
import org.menaphos.model.command.Command;
import org.menaphos.model.command.CommandRepository;
import org.phantasye.RepositoryManager;

public class CommandRepositoryManager extends RepositoryManager<Command, CommandRepository> {

    public CommandRepositoryManager() {
        super(Menaphos.getInstance().requestRepository(Menaphos.Repository.COMMANDS).getAbsolutePath(), CommandRepository.class);
    }
}
