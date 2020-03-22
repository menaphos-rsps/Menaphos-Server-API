package org.menaphos.model.entity;

public class EntityDetails {

    private final Object id;

    public EntityDetails(Object id) {
        this.id = id;
    }

    public Object getId() {
        return id;
    }

    public String getIdAsString() {
        return (String) id;
    }

    public void init() {

    }
}
