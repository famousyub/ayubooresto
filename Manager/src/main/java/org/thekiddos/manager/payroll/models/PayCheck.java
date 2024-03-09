package org.thekiddos.manager.payroll.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

/**
 * A paycheck that is giving to an employee as a payment
 */
@Getter
@RequiredArgsConstructor
public class PayCheck {
    @NonNull
    private final LocalDate payDate;
    @NonNull
    private final double amount;
    @NonNull
    private final String details;
    @NonNull
    private final Employee employee;
	public LocalDate getPayDate() {
		return payDate;
	}
	public double getAmount() {
		return amount;
	}
	public String getDetails() {
		return details;
	}
	public Employee getEmployee() {
		return employee;
	}
	public PayCheck(@NonNull LocalDate payDate, @NonNull double amount, @NonNull String details,
			@NonNull Employee employee) {
		super();
		this.payDate = payDate;
		this.amount = amount;
		this.details = details;
		this.employee = employee;
	}
    
    
}
