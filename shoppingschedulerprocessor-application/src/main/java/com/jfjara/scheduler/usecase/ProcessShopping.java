package com.jfjara.scheduler.usecase;

import com.jfjara.scheduler.model.ShoppingDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class ProcessShopping {

    public Optional<List<ShoppingDTO>> execute(final List<ShoppingDTO> shoppingDTOS) {
        return Optional.ofNullable(shoppingDTOS
                .stream()
                .filter(s -> s.getTotalPrice() > 500L)
                .collect(Collectors.toList()));
    }

}
