package org.menaphos.model.finance.transaction.currency;

public final class Currency {

    public static enum Type {
        POINT,ITEM;
    }

    private final String id;
    private final Type type;

    public Currency(String id, Type type) {
        this.id = id;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}

