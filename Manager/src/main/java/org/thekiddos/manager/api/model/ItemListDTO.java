package org.thekiddos.manager.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemListDTO implements Serializable {
    private List<ItemDTO> items;

	public List<ItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}

	public ItemListDTO(List<ItemDTO> items) {
		super();
		this.items = items;
	}

	public ItemListDTO() {
		super();
	}
    
    
    
}
