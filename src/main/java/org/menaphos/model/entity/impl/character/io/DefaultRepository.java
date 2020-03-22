package org.menaphos.model.entity.impl.character.io;

import org.menaphos.model.entity.impl.character.CharacterDetails;
import org.phantasye.AbstractJsonRepository;

public final class DefaultRepository extends AbstractJsonRepository<CharacterDetails> {

    @Override
    public void create(CharacterDetails details) {
        entries.put(details.getId(),details);
    }

    @Override
    public CharacterDetails read(CharacterDetails details) {
        return entries.get(details.getId());
    }

    @Override
    public void delete(CharacterDetails details) {
        entries.remove(details.getId());
    }
}
