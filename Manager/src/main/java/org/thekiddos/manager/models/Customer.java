package org.thekiddos.manager.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.thekiddos.manager.repositories.Database;

import javax.persistence.Table;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Customer {
    @NonNull @Id
    private Long id;
    @NonNull
    private String name;
    private String email;
    private LocalDateTime email_verified_at;
    private String password;
    private String remember_token;

    @ManyToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    @JoinTable( name = "recommendations", joinColumns = @JoinColumn( name = "user_id" ),
    inverseJoinColumns = @JoinColumn( name = "item_id" ) )
    private Set<Item> recommendations;

    public Customer( Long id, String name, String email, String password ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Check if the customer has any current or future reservations
     * @return true if the customer has any reservations
     */
    public boolean hasReservation() {
        return Database.customerHasReservations( id );
    }

    /**
     * Check if the customer has any current or future deliveries
     * @return true if the customer has any deliveries
     */
    public boolean hasDelivery() {
        return Database.getDeliveryByCustomerId( id ).size() > 0;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getEmail_verified_at() {
		return email_verified_at;
	}

	public void setEmail_verified_at(LocalDateTime email_verified_at) {
		this.email_verified_at = email_verified_at;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemember_token() {
		return remember_token;
	}

	public void setRemember_token(String remember_token) {
		this.remember_token = remember_token;
	}

	public Set<Item> getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(Set<Item> recommendations) {
		this.recommendations = recommendations;
	}

	public Customer(@NonNull Long id, @NonNull String name, String email, LocalDateTime email_verified_at,
			String password, String remember_token, Set<Item> recommendations) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.email_verified_at = email_verified_at;
		this.password = password;
		this.remember_token = remember_token;
		this.recommendations = recommendations;
	}

	public Customer() {
		super();
	}
	
	
    
    
    
}
