package com.jfjara.scheduler.mapper;

import com.jfjara.scheduler.model.ShoppingDTO;
import com.jfjara.shoppinggenerator.model.Shopping;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface ShoppingMapper {

    @Named("asShoppingDTO")
    ShoppingDTO asShoppingDTO(final Shopping dto);

    @IterableMapping(qualifiedByName = "asShoppingDTO")
    List<ShoppingDTO> asShoppingDTOList(final List<Shopping> dto);

}
