package org.thekiddos.manager.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class OrderedItem {
    private final String itemName;
    private final int quantity;
    private final double unitPrice;
	public String getItemName() {
		return itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public OrderedItem(String itemName, int quantity, double unitPrice) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

    
    
}
