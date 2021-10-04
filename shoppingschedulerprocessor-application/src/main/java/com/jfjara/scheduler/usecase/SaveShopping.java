package com.jfjara.scheduler.usecase;

import com.jfjara.scheduler.cache.CacheRepository;
import com.jfjara.scheduler.model.ShoppingDTO;

import java.util.List;
import java.util.Optional;

public class SaveShopping {

    private final CacheRepository<String, ShoppingDTO> cacheRepository;

    public SaveShopping(final CacheRepository<String, ShoppingDTO> cacheRepository) {
        this.cacheRepository = cacheRepository;
    }

    public void execute(Optional<List<ShoppingDTO>> shoppingDTOS) {
        cacheRepository.add(shoppingDTOS);
    }

}
