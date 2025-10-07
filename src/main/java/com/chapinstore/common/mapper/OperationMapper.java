package com.chapinstore.common.mapper;

import com.chapinstore.dto.security.operation.request.OperationCreationDto;
import com.chapinstore.entity.security.Operation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OperationMapper {

    Operation toOperation(OperationCreationDto operationCreationDto);

}
