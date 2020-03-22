package org.menaphos.model.entity.impl.npc.impl.mob;

import org.menaphos.model.entity.EntityDetails;

public class MobDetails extends EntityDetails {

    public MobDetails(int id) {
        super(id);
    }

    @Override
    public Integer getId() {
        return (Integer) super.getId();
    }
}
