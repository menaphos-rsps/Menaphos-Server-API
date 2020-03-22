package org.menaphos.model.world.content.shop.model.merchandise;

import org.menaphos.Menaphos;
import org.phantasye.RepositoryManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class MerchandiseFactory {

    private static final Map<Integer, Merchandise> merchandiseMap = new HashMap<>();

    public static Optional<Merchandise> getMerchandise(int id) {
        Merchandise merchandise = merchandiseMap.get(id);

        if (merchandise == null) {
            RepositoryManager<Merchandise, MerchandiseRepository> rm = Menaphos.getMerchandiseRepositoryManager();
            merchandise = rm.getRepository().readByKey(String.valueOf(id));
            if (merchandise == null) {
                return Optional.empty();
            }
            merchandiseMap.put(id, merchandise);
        }
        return Optional.of(merchandise);
    }
}
