package com.jfjara.scheduler.usecase;

import com.jfjara.scheduler.client.ShoppingsClient;
import com.jfjara.scheduler.model.ShoppingDTO;

import java.util.List;
import java.util.Optional;

public class GetShoppings {

    private final ShoppingsClient shoppingsClient;

    public GetShoppings(final ShoppingsClient shoppingsClient) {
        this.shoppingsClient = shoppingsClient;
    }

    public Optional<List<ShoppingDTO>> execute() {
        return shoppingsClient.get();
    }
}
