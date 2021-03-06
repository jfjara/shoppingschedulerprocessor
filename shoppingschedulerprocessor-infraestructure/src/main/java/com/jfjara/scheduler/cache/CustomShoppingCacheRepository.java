package com.jfjara.scheduler.cache;

import com.jfjara.scheduler.model.ShoppingDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomShoppingCacheRepository implements CacheRepository<String, ShoppingDTO> {

    private final Map<String, ShoppingDTO> cache;

    public CustomShoppingCacheRepository(final Map<String, ShoppingDTO> cache) {
        this.cache = cache;
    }

    @Override
    public void add(final Optional<List<ShoppingDTO>> shoppingDTOS) {
        shoppingDTOS.ifPresent(l -> add(l));
    }

    private void add(final List<ShoppingDTO> list) {
        list.stream().forEach(e -> add(e.getId(), e));
    }

    @Override
    public void add(String key, ShoppingDTO element) {
        cache.put(key, element);
    }

    @Override
    public Optional<ShoppingDTO> get(String key) {
        if (key == null ||
                key.isBlank() ||
                !cache.containsKey(key)) {
            return Optional.empty();
        }
        return Optional.ofNullable(cache.get(key));
    }
}
