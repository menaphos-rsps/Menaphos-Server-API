package org.menaphos.model.world.content.shop.model.merchandise;

import org.phantasye.AbstractJsonRepository;

public class MerchandiseRepository extends AbstractJsonRepository<Merchandise> {
    @Override
    public void create(Merchandise merchandise) {
        entries.put(String.valueOf(merchandise.getId()), merchandise);
    }

    @Override
    public Merchandise read(Merchandise merchandise) {
        return entries.get(String.valueOf(merchandise.getId()));
    }

    @Override
    public void delete(Merchandise merchandise) {
        entries.remove(String.valueOf(merchandise.getId()));
    }
}
