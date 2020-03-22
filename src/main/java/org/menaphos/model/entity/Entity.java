package org.menaphos.model.entity;

public abstract class Entity<D extends EntityDetails> {

    private final Object id;
    private final D details;

    protected Entity(Object id, D details) {
        this.id = id;
        this.details = details;
    }

    public abstract void save();

    public abstract void send(String message);
    public abstract void receive(String message);

    public Object getId() {
        return  id;
    }

    public D getDetails() {
        return details;
    }

}
