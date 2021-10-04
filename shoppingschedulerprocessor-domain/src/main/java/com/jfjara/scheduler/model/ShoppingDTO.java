package com.jfjara.scheduler.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

@Value
@Builder(toBuilder = true)
public class ShoppingDTO {

    String id;
    PersonDTO person;
    List<ProductDTO> products;
    Long registerTimestamp;

    public Long getTotalPrice() {
        List<Long> prices = products.stream()
                .map(p -> p.getPrice())
                .collect(Collectors.toList());
        return prices.stream()
                .reduce(0L, (a, b) -> a + b);
    }

}
