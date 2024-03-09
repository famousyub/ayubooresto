package org.thekiddos.manager.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderedItemsDTO implements Serializable {
    private TableDTO table;
    private List<ItemDTO> items;
	public TableDTO getTable() {
		return table;
	}
	public void setTable(TableDTO table) {
		this.table = table;
	}
	public List<ItemDTO> getItems() {
		return items;
	}
	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}
	public OrderedItemsDTO(TableDTO table, List<ItemDTO> items) {
		super();
		this.table = table;
		this.items = items;
	}
	public OrderedItemsDTO() {
		super();
	}
    
    
    
}
