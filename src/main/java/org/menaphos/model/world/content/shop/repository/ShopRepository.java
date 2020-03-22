package org.menaphos.model.world.content.shop.repository;

import org.menaphos.model.world.content.shop.Shop;
import org.phantasye.AbstractJsonRepository;

public class ShopRepository extends AbstractJsonRepository<Shop> {
    @Override
    public void create(Shop shop) {
        entries.put(String.valueOf(shop.getContext().getId()),shop);
    }

    @Override
    public Shop read(Shop shop) {
        return entries.get(String.valueOf(shop.getContext().getId()));
    }

    @Override
    public void delete(Shop shop) {
        entries.remove(String.valueOf(shop.getContext().getId()));
    }
}
