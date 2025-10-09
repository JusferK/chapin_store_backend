package com.chapinstore.common.mapper;

import com.chapinstore.dto.menu.request.MenuOperationCreationDto;
import com.chapinstore.entity.menu.MenuOperation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuOperationMapper {

    MenuOperation toMenuOperation(MenuOperationCreationDto request);

}
