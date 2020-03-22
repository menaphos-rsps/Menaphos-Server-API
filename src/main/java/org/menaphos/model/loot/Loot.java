package org.menaphos.model.loot;

import org.menaphos.entity.impl.item.Item;
import org.menaphos.model.math.Range;

public class Loot {
	
	private Item item;
	private float percentDrop;
	private Range range;

	public Loot(Item item, float percentDrop) {
		this(item,percentDrop,null);
	}

	public Loot(Item item, float percentDrop, Range range) {
		this.item = item;
		this.percentDrop = percentDrop;
		this.range = range;
	}

	public Range getRange() {
		return range;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setRange(Range range) {
		this.range = range;
	}

	public Item getItem() {
		return item;
	}

	public float getPercentDrop() {
		return percentDrop;
	}

	public void setPercentDrop(float percentDrop) {
		this.percentDrop = percentDrop;
	}

	@Override
	public String toString() {
		return "ID:" + item.getId() + " | QTY:" + item.getAmount() + " | CHANCE:" + percentDrop + "%";
	}

}
