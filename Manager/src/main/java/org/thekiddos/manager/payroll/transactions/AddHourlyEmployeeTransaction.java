package org.thekiddos.manager.payroll.transactions;

import lombok.Getter;
import lombok.Setter;
import org.thekiddos.manager.payroll.models.HourlyClassification;
import org.thekiddos.manager.payroll.models.PaymentClassification;
import org.thekiddos.manager.payroll.models.PaymentSchedule;
import org.thekiddos.manager.payroll.models.WeeklySchedule;

@Getter
@Setter
public class AddHourlyEmployeeTransaction extends AddEmployeeTransaction {
    private double hourlyRate;
    private double overHoursBonusRate = 1.5;
    private int overHoursThreshold = 8;

    /**
     * @throws IllegalArgumentException if an employee with this id already exists
     */
    public AddHourlyEmployeeTransaction( Long empId, String name, double hourlyRate ) {
        super( empId, name );
        this.hourlyRate = hourlyRate;
    }

    @Override
    PaymentClassification getPaymentClassification() {
        return new HourlyClassification( hourlyRate, overHoursBonusRate, overHoursThreshold );
    }

    @Override
    PaymentSchedule getPaymentSchedule() {
        return new WeeklySchedule();
    }

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public double getOverHoursBonusRate() {
		return overHoursBonusRate;
	}

	public void setOverHoursBonusRate(double overHoursBonusRate) {
		this.overHoursBonusRate = overHoursBonusRate;
	}

	public int getOverHoursThreshold() {
		return overHoursThreshold;
	}

	public void setOverHoursThreshold(int overHoursThreshold) {
		this.overHoursThreshold = overHoursThreshold;
	}
    
    
}
