package org.thekiddos.manager.payroll.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * A time card holds information about hours worked on a date for an employee
 * it has a direct relation with the {@link HourlyClassification}
 */
@Entity
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "TIMECARD")
public class TimeCard implements Serializable {
    @EmbeddedId @NonNull
    private TimeCardId timeCardId;

    @NonNull
    private LocalTime timeWorked;

    public LocalDate getDate() {
        return timeCardId.getDate();
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        TimeCard timeCard = (TimeCard) o;
        return timeCardId.equals( timeCard.timeCardId );
    }

    @Override
    public int hashCode() {
        return Objects.hash( timeCardId );
    }

	public TimeCardId getTimeCardId() {
		return timeCardId;
	}

	public void setTimeCardId(TimeCardId timeCardId) {
		this.timeCardId = timeCardId;
	}

	public LocalTime getTimeWorked() {
		return timeWorked;
	}

	public void setTimeWorked(LocalTime timeWorked) {
		this.timeWorked = timeWorked;
	}

	public TimeCard(@NonNull TimeCardId timeCardId, @NonNull LocalTime timeWorked) {
		super();
		this.timeCardId = timeCardId;
		this.timeWorked = timeWorked;
	}

	public TimeCard() {
		super();
	}
	
	
    
    
}
