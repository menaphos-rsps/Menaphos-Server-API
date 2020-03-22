package org.menaphos.entity.impl.impl;

import org.menaphos.entity.impl.EntityDetails;

public class PlayerDetails extends EntityDetails {

    public PlayerDetails(long id) {
        super(id);
    }

    @Override
    public Long getId() {
        return (long) super.getId();
    }
}
