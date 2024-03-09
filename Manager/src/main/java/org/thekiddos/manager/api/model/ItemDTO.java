package org.thekiddos.manager.api.model;

import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ItemDTO implements Serializable {
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private double price;
    private double calories;
    private double fat;
    private double protein;
    private double carbohydrates;
    private String imagePath;
    private String description;

    private Set<TypeDTO> types = new HashSet<>();

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

	public Set<TypeDTO> getTypes() {
		return types;
	}

	public void setTypes(Set<TypeDTO> types) {
		this.types = types;
	}

	public ItemDTO(@NonNull Long id, @NonNull String name, @NonNull double price, double calories, double fat,
			double protein, double carbohydrates, String imagePath, String description, Set<TypeDTO> types) {
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

	public ItemDTO() {
		super();
	}
	
	
    
    
}
