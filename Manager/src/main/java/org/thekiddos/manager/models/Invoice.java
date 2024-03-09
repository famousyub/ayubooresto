package org.thekiddos.manager.models;

import lombok.Getter;
import org.thekiddos.manager.Util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Invoice that contains all information about the reservation and ordered items.
 */
@Getter
public class Invoice {
    private final double total;
    private final double orderTotal;
    private final double tableFee;
    private final double reservationFee;
    private final double deliveryFee;
    private final String deliveryAddress;
    private final double discount;
    private final double netAmount;
    private final Long tableId;
    private final Long customerId;
    private final LocalDate date = LocalDate.now();
    private final LocalTime time = LocalTime.now();
    private final Map<Item, Integer> items;

    public Invoice( Service service, double discount, boolean isReservation ) {
        customerId = service.getCustomerId();
        this.discount = discount;
        orderTotal = service.getOrder().getTotal();
        total = service.getTotal();
        netAmount = service.getTotal() - discount;
        items = new HashMap<>( service.getOrder().getItemsQuantities() );

        if ( isReservation ) {
            Reservation reservation = (Reservation) service;
            tableId = reservation.getTable().getId();
            reservationFee = reservation.getReservationFee();
            tableFee = reservation.getTableFee();
            deliveryFee = 0;
            deliveryAddress = null;
        }
        else {
            Delivery delivery = (Delivery) service;
            tableId = Util.INVALID_ID;
            reservationFee = 0;
            tableFee = 0;
            deliveryFee = delivery.getDeliveryFee();
            deliveryAddress = delivery.getDeliveryAddress();
        }
    }


	public double getTotal() {
		return total;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public double getTableFee() {
		return tableFee;
	}

	public double getReservationFee() {
		return reservationFee;
	}

	public double getDeliveryFee() {
		return deliveryFee;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public double getDiscount() {
		return discount;
	}

	public double getNetAmount() {
		return netAmount;
	}

	public Long getTableId() {
		return tableId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public LocalDate getDate() {
		return date;
	}

	public LocalTime getTime() {
		return time;
	}

	public Map<Item, Integer> getItems() {
		return items;
	}
    
    
}
