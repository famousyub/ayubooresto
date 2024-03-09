package org.thekiddos.manager.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableListDTO implements Serializable {
    private List<TableDTO> tables;

	public List<TableDTO> getTables() {
		return tables;
	}

	public void setTables(List<TableDTO> tables) {
		this.tables = tables;
	}

	public TableListDTO(List<TableDTO> tables) {
		super();
		this.tables = tables;
	}

	public TableListDTO() {
		super();
	}
    
    
}
