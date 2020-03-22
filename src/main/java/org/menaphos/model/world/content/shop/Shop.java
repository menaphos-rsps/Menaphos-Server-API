package org.menaphos.model.world.content.shop;

import org.menaphos.Menaphos;
import org.menaphos.entity.impl.item.Item;
import org.menaphos.entity.impl.item.container.impl.MerchandiseItemContainerImpl;
import org.menaphos.model.finance.transaction.Transaction;
import org.menaphos.model.finance.transaction.Transactor;
import org.menaphos.model.finance.transaction.currency.CurrencyRequest;
import org.menaphos.model.task.impl.RestockTask;
import org.menaphos.model.world.content.shop.model.PurchaseRequest;
import org.menaphos.model.world.content.shop.model.merchandise.Merchandise;
import org.menaphos.model.world.content.shop.model.merchandise.MerchandiseFactory;
import org.menaphos.model.world.content.shop.model.merchandise.Stock;

import java.util.Optional;

public class Shop extends MerchandiseItemContainerImpl implements Transactor {

    private final ShopContext context;

    public Shop(ShopContext context) {
        super(42);
        this.context = context;
    }

    @Override
    public boolean transact(Transaction transaction) {
        return transaction.transact();
    }

    public int total(int id, int amount) {
        if (this.contains(id)) {
            final Merchandise merchandise = MerchandiseFactory.getMerchandise(id).orElse(new Merchandise(new Stock(new Item(id), amount, amount)));
            if (merchandise.isBasicMerchandise()) {
                return this.getContext().getProfitMargin().markupItem(id) * amount;
            } else if (merchandise.isMarkedUp() && !merchandise.isPriced()) {
                return this.getContext().getProfitMargin().markup(merchandise.getMarkup().markupItem(id)) * amount;
            } else if (merchandise.isPriced() && !merchandise.isMarkedUp()) {
                return this.getContext().getProfitMargin().markup(merchandise.getBasePrice()) * amount;
            } else {
                return this.getContext().getProfitMargin().markup(merchandise.getMarkup().markup(merchandise.getBasePrice()) * amount);
            }
        }
        return 0;
    }

    public int value(int id, int amount) {
        final Merchandise merchandise = MerchandiseFactory.getMerchandise(id).orElse(new Merchandise(new Stock(new Item(id), amount, amount)));
        if (merchandise.isBasicMerchandise()) {
            return this.getContext().getProfitMargin().markdownItem(id) * amount;
        } else if (merchandise.isMarkedUp() && !merchandise.isPriced()) {
            return this.getContext().getProfitMargin().markdownItem(merchandise.getMarkup().markdownItem(id)) * amount;
        } else if (merchandise.isPriced() && !merchandise.isMarkedUp()) {
            return this.getContext().getProfitMargin().markdown(merchandise.getBasePrice()) * amount;
        } else {
            return this.getContext().getProfitMargin().markdown(merchandise.getMarkup().markdown(merchandise.getBasePrice()) * amount);
        }
    }

    public Optional<PurchaseRequest> sell(int id, int amount) {
        if (this.remove(id, amount)) {
            this.restock(id);
            return Optional.of(new PurchaseRequest(id, amount, total(id, amount)));
        }
        return Optional.empty();
    }

    public Optional<CurrencyRequest> buy(int id, int amount) {
        if(context.isResale()) {
            if (this.add(id, amount)) {
                return Optional.of(new CurrencyRequest(this.getContext().getCurrency().getId(), value(id, amount)));
            }
        }
        return Optional.empty();
    }

    private boolean restock(int itemId) {
        if(!context.isResale()) {
            if(this.capForItem(itemId) > this.onHandForItem(itemId)) {
                Menaphos.getInstance().scheduleTask(new RestockTask(context.getRefreshRate(), itemId,this));
                return true;
            }
        }
        return false;
    }

    private int capForItem(int id) {
        return MerchandiseFactory.getMerchandise(id).isPresent() ? MerchandiseFactory.getMerchandise(id).get().getStock().getCap() : 0;
    }

    private int onHandForItem(int id) {
        return this.contains(id) ? this.getItemById(id).getAmount().value() : 0;
    }

    public ShopContext getContext() {
        return context;
    }
}
