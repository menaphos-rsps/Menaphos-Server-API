package org.menaphos.model.entity.impl.character;

import org.menaphos.event.impl.entity.character.impl.inventory.InventoryDepositEvent;
import org.menaphos.event.impl.entity.character.impl.inventory.InventoryEvent;
import org.menaphos.event.impl.entity.character.impl.inventory.InventoryWithdrawalEvent;
import org.menaphos.event.listener.MenaphosEventListener;
import org.menaphos.model.entity.Entity;
import org.menaphos.entity.impl.item.container.ItemContainer;
import org.menaphos.entity.impl.item.container.impl.DefaultItemContainerImpl;
import org.menaphos.model.finance.transaction.Transaction;
import org.menaphos.model.finance.transaction.Transactor;
import org.menaphos.model.finance.transaction.currency.Currency;
import org.menaphos.model.roles.Role;
import org.menaphos.model.world.content.shop.model.PurchaseRequest;
import org.menaphos.model.world.content.shop.model.shopper.Customer;
import org.menaphos.model.world.content.shop.model.shopper.session.ShoppingSession;
import org.menaphos.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Character<D extends CharacterDetails> extends Entity<D> implements Customer, Transactor, Role {

    private final List<MenaphosEventListener<InventoryEvent>> inventoryListeners;
    private final ItemContainer inventory;
    private ShoppingSession shoppingSession;

    public Character(String id, D details) {
        super(id, details);
        this.inventory = new DefaultItemContainerImpl(28);
        this.inventoryListeners = new ArrayList<>();
    }

    public abstract int getLevel(int skill);

    @Override
    public Optional<PurchaseRequest> purchase(int id, int amount) {
        final int cost = shoppingSession.getShop().total(id, amount);
        if (shoppingSession.getShop().getContext().getCurrency().getType() == Currency.Type.ITEM) {
            final int item = Integer.parseInt(shoppingSession.getShop().getContext().getCurrency().getId());
            if (this.getInventory().remove(item, cost)) {
                return shoppingSession.getShop().sell(id, amount);
            }
        } else {
            final String point = shoppingSession.getShop().getContext().getCurrency().getId();
            if (this.getDetails().getPointMap().get(point).contains(cost)) {
                this.getDetails().getPointMap().get(point).subtract(cost);
                return shoppingSession.getShop().sell(id, amount);
            }
        }
        this.send("You can not afford that. (" + StringUtils.formatInteger(cost) + " GP)");
        return Optional.empty();
    }

    @Override
    public Optional<Integer> inquire(int slot) {
        return Optional.of(shoppingSession.getShop().total(shoppingSession.getShop().getSlot(slot).getId(), 1));
    }

    @Override
    public Optional<Integer> appraise(int slot) {
        return Optional.of(shoppingSession.getShop().value(this.getInventory().getSlot(slot).getId(),1));
    }

    @Override
    public String getId() {
        return this.getDetails().getId();
    }

    @Override
    public boolean transact(Transaction transaction) {
        return transaction.transact();
    }

    public <M extends MenaphosEventListener<InventoryEvent>> boolean addInventoryEventListener(M inventoryListener) {
        return inventoryListeners.add(inventoryListener);
    }

    public void addItemToInventory(int itemId, int amount) {
        inventoryListeners.forEach(listener->
                listener.handle(new InventoryDepositEvent(this,itemId,amount)));
    }

    public void removeItemFromInventory(int itemId, int amount) {
        inventoryListeners.forEach(listener->
                listener.handle(new InventoryWithdrawalEvent(this,itemId,amount)));
    }

    private void registerListeners() {

    }

    public ItemContainer getInventory() {
        return inventory;
    }

    public void setShoppingSession(ShoppingSession shoppingSession) {
        this.shoppingSession = shoppingSession;
    }

    public ShoppingSession getShoppingSession() {
        return shoppingSession;
    }
}
