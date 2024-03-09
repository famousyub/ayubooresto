package org.thekiddos.manager.api.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.thekiddos.manager.api.model.TableDTO;
import org.thekiddos.manager.models.Table;

@Mapper(componentModel = "spring")
@Component
public interface TableMapper {

    TableDTO tableToTableDTO( Table table );
}
