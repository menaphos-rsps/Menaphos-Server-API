package org.menaphos.io.fs.repository;

import org.menaphos.Menaphos;
import org.menaphos.model.world.content.shop.Shop;
import org.menaphos.model.world.content.shop.repository.ShopRepository;
import org.phantasye.RepositoryManager;

public final class ShopRepositoryManager extends RepositoryManager<Shop, ShopRepository> {

    public ShopRepositoryManager() {
        super(Menaphos.getInstance().requestRepository(Menaphos.Repository.SHOP).getAbsolutePath(), ShopRepository.class);
    }
}
