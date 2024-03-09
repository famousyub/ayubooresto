package org.thekiddos.manager.payroll.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Entity
@NoArgsConstructor
@Getter
@RequiredArgsConstructor
@Table(name = "HOURLY_CLASSIFICATION")
public class HourlyClassification extends PaymentClassification {
    private static final double DAYS_IN_MONTH = 30;
    @NonNull
    private double hourlyRate;
    @NonNull
    private double overHoursBonusRate;
    @NonNull
    private int overHoursThreshold;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "HOURLY_CLASSIFICATION_ID", referencedColumnName = "ID")
    @MapKey(name = "timeCardId.date")
    private final Map<LocalDate, TimeCard> timeCards = new HashMap<>();

    public TimeCard getTimeCard( LocalDate date ) {
        return timeCards.get( date );
    }

    public void addTimeCard( TimeCard timeCard ) {
        // TODO Should we check if the timeCard already exists?
        timeCards.put( timeCard.getDate(), timeCard );
    }

    @Override
    public double calculatePay( LocalDate startData, LocalDate endDate ) {
        double amount = 0;

        for ( LocalDate unPaidDay = startData; isBeforeOrEqual( unPaidDay, endDate ); unPaidDay = unPaidDay.plusDays( 1 ) ) {
            TimeCard timeCard = timeCards.get( unPaidDay );
            amount += calculateTimeCardPay( timeCard );
        }

        return amount;
    }

    @Override
    public String getType() {
        return "Hourly Employee";
    }

    @Override
    public String getBaseSalary() {
        return hourlyRate + " per normal hour";
    }

    @Override
    public double calculateCompensation() {
        return hourlyRate * overHoursThreshold * DAYS_IN_MONTH;
    }

    private double calculateTimeCardPay( TimeCard timeCard ) {
        if ( timeCard == null )
            return 0;

        double totalHours = getTotalHours( timeCard.getTimeWorked() );
        double overHours = Math.max( 0.0, totalHours - 8.0 );
        double normalHours = totalHours - overHours;
        return normalHours * hourlyRate + overHours * hourlyRate * overHoursBonusRate;
    }

    private double getTotalHours( LocalTime timeWorked ) {
        return timeWorked.getHour() + timeWorked.getMinute() / 60.0;
    }

    private boolean isBeforeOrEqual( LocalDate unPaidDay, LocalDate endDate ) {
        return unPaidDay.isBefore( endDate ) || unPaidDay.isEqual( endDate );
    }

    @Override
    public String toString() {
        return "Hourly Rate: " + hourlyRate;
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

	public static double getDaysInMonth() {
		return DAYS_IN_MONTH;
	}

	public Map<LocalDate, TimeCard> getTimeCards() {
		return timeCards;
	}

	public HourlyClassification(@NonNull double hourlyRate, @NonNull double overHoursBonusRate,
			@NonNull int overHoursThreshold) {
		super();
		this.hourlyRate = hourlyRate;
		this.overHoursBonusRate = overHoursBonusRate;
		this.overHoursThreshold = overHoursThreshold;
	}
    
    
}
