package org.thekiddos.manager.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceId implements Serializable {
    @Column(name = "user_id")
    private Long customerId;
    private LocalDate date;

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        ServiceId serviceId = (ServiceId) o;
        return customerId.equals( serviceId.customerId ) &&
                date.equals( serviceId.date );
    }

    @Override
    public int hashCode() {
        return Objects.hash( customerId, date );
    }

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public ServiceId() {
		super();
	}

	public ServiceId(Long customerId, LocalDate date) {
		super();
		this.customerId = customerId;
		this.date = date;
	}
	
	
    
    
}
