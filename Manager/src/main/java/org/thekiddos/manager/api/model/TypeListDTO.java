package org.thekiddos.manager.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TypeListDTO implements Serializable {
    private List<TypeDTO> types;

	public List<TypeDTO> getTypes() {
		return types;
	}

	public void setTypes(List<TypeDTO> types) {
		this.types = types;
	}

	public TypeListDTO(List<TypeDTO> types) {
		super();
		this.types = types;
	}

	public TypeListDTO() {
		super();
	}
    
    
}
