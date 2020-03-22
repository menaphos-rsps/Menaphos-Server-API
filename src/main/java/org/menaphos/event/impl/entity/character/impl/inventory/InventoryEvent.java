package org.menaphos.event.impl.entity.character.impl.inventory;

import org.menaphos.event.impl.entity.character.CharacterEvent;
import org.menaphos.model.entity.impl.character.Character;
import org.menaphos.model.finance.transaction.Transaction;

public class InventoryEvent extends CharacterEvent {

    private final Transaction transaction;

    protected InventoryEvent(Character entity, Transaction transaction) {
        super(entity);
        this.transaction = transaction;
    }

    @Override
    public boolean execute() {
        return this.getEntity().transact(transaction);
    }

    public Transaction getTransaction() {
        return transaction;
    }
}
