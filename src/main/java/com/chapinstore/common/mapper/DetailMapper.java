package com.chapinstore.common.mapper;

import com.chapinstore.dto.detail.request.DetailCreationRequestDto;
import com.chapinstore.dto.detail.response.DetailRetrieveDto;
import com.chapinstore.entity.Detail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetailMapper {

    Detail toDetail(DetailCreationRequestDto detailCreationRequestDto);
    DetailRetrieveDto toDetailRetrieveDto(Detail detail);

}
