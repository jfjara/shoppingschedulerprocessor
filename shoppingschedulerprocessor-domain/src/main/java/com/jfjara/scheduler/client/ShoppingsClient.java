package com.jfjara.scheduler.client;

import com.jfjara.scheduler.model.ShoppingDTO;

import java.util.List;
import java.util.Optional;

public interface ShoppingsClient {

    Optional<List<ShoppingDTO>> get();

}
