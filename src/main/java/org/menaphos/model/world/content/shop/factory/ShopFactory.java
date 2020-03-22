package org.menaphos.model.world.content.shop.factory;

import org.menaphos.io.fs.repository.ShopRepositoryManager;
import org.menaphos.model.world.content.shop.Shop;
import org.menaphos.model.world.content.shop.repository.ShopRepository;
import org.phantasye.RepositoryManager;

import java.util.HashMap;
import java.util.Map;

public final class ShopFactory {

    private static final Map<Integer,Shop> shopMap = new HashMap<>();

    public static Shop getShop(int id) {
        Shop shop = shopMap.get(id);

        if (shop == null) {
            final RepositoryManager<Shop, ShopRepository> rm = new ShopRepositoryManager();
            shop = rm.getRepository().readByKey(String.valueOf(id));
            if (shop == null) {
                throw new NullPointerException("No Shop Present: " + id);
            }
            shopMap.put(id,shop);
        }
        return shop;
    }
}
