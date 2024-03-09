package org.thekiddos.manager.models;

import lombok.*;

import javax.persistence.Table;
import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "items")
public class Item {
    @NonNull @Id @Getter
    private Long id;
    @NonNull @Getter
    private String name;
    @NonNull @Getter
    private double price;
    @Getter
    private double calories;
    @Getter
    private double fat;
    @Getter
    private double protein;
    @Getter
    private double carbohydrates;
    @Getter @Column(name = "image")
    private String imagePath;
    @Getter
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Type> types = new HashSet<>();

    public Set<Type> getTypes() {
        return Collections.unmodifiableSet( types );
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Item item = (Item) o;
        return id.equals( item.id );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id );
    }

    /**
     * While the Object equals method only compares the Id of the items
     * this method compares all important fields (name, price, ...etc). This is especially useful when comparing the item to another item which was
     * generated outside the current program eg: REST API Post request.
     * @param other The item to compare the current item to
     * @return true if both items match, false otherwise.
     */
    public boolean deepEquals( Item other ) {
        if ( other == null )
            return false;
        return id.equals( other.getId() ) &&
                name.equals( other.getName() ) &&
                price == other.getPrice() &&
                types.equals( other.getTypes() );
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTypes(Set<Type> types) {
		this.types = types;
	}

	public Item(@NonNull Long id, @NonNull String name, @NonNull double price, double calories, double fat,
			double protein, double carbohydrates, String imagePath, String description, Set<Type> types) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.calories = calories;
		this.fat = fat;
		this.protein = protein;
		this.carbohydrates = carbohydrates;
		this.imagePath = imagePath;
		this.description = description;
		this.types = types;
	}

	public Item() {
		super();
	}

	public Item(@NonNull String name, @NonNull double price, double calories) {
		super();
		this.name = name;
		this.price = price;
		this.calories = calories;
	}

	public Item(@NonNull String name, String description, @NonNull double price) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public Item(@NonNull double price, String description, Set<Type> types) {
		super();
		this.price = price;
		this.description = description;
		this.types = types;
	}

	public Item(@NonNull double price, String imagePath, String description) {
		super();
		this.price = price;
		this.imagePath = imagePath;
		this.description = description;
	}
	
	
	
	
	
    
    
}
