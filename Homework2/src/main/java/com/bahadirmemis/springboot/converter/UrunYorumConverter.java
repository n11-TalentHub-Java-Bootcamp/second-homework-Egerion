package com.bahadirmemis.springboot.converter;

import com.bahadirmemis.springboot.dto.UrunYorumDto;
import com.bahadirmemis.springboot.entity.UrunYorum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UrunYorumConverter {

    UrunYorumConverter INSTANCE = Mappers.getMapper(UrunYorumConverter.class);

    @Mapping(source="id", target="urunId")
    UrunYorum convertUrunYorumDtoToUrunYorum(UrunYorumDto urunYorumDto);

}
