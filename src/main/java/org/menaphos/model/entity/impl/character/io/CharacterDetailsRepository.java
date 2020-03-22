package org.menaphos.model.entity.impl.character.io;

import org.menaphos.model.entity.impl.character.CharacterDetails;
import org.phantasye.AbstractJsonRepository;

public class CharacterDetailsRepository<D extends CharacterDetails> extends AbstractJsonRepository<D> {

    @Override
    public void create(D details) {
        entries.put(details.getId(),details);
    }

    @Override
    public D read(D details) {
        return entries.get(details.getId());
    }

    @Override
    public void delete(D details) {
        entries.remove(details.getId());
    }
}
