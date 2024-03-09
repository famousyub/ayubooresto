package org.thekiddos.manager.payroll.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Employee {
    @NonNull @Id
    private Long id;
    @NonNull
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private PaymentClassification paymentClassification;
    @OneToOne(cascade = CascadeType.ALL)
    private PaymentSchedule paymentSchedule;
    @OneToOne(cascade = CascadeType.ALL)
    private PaymentMethod paymentMethod;

    public boolean isPayDay( LocalDate payDay ) {
        return paymentSchedule.isPayDay( payDay );
    }

    public PayCheck payDay( LocalDate payDate ) {
        LocalDate startPayDay = paymentSchedule.getStartPayDay( payDate );
        double amount = paymentClassification.calculatePay( startPayDay, payDate );
        PayCheck payCheck = new PayCheck( payDate, amount, paymentMethod.getDetails(), this );
        paymentMethod.pay( payCheck );
        return payCheck;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PaymentClassification getPaymentClassification() {
		return paymentClassification;
	}

	public void setPaymentClassification(PaymentClassification paymentClassification) {
		this.paymentClassification = paymentClassification;
	}

	public PaymentSchedule getPaymentSchedule() {
		return paymentSchedule;
	}

	public void setPaymentSchedule(PaymentSchedule paymentSchedule) {
		this.paymentSchedule = paymentSchedule;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Employee(@NonNull Long id, @NonNull String name, PaymentClassification paymentClassification,
			PaymentSchedule paymentSchedule, PaymentMethod paymentMethod) {
		super();
		this.id = id;
		this.name = name;
		this.paymentClassification = paymentClassification;
		this.paymentSchedule = paymentSchedule;
		this.paymentMethod = paymentMethod;
	}

	public Employee() {
		super();
	}

	public Employee(@NonNull Long id, @NonNull String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
    
    
}
