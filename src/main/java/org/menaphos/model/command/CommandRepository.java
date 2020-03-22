package org.menaphos.model.command;

import org.phantasye.AbstractJsonRepository;

public class CommandRepository extends AbstractJsonRepository<Command> {
    @Override
    public void create(Command command) {
        entries.put(command.getIdentifier(),command);
    }

    @Override
    public Command read(Command command) {
        return entries.get(command.getIdentifier());
    }

    @Override
    public void delete(Command command) {
        entries.remove(command.getIdentifier());
    }
}
