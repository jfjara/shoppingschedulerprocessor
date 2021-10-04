package com.jfjara.scheduler.cache;

import java.util.List;
import java.util.Optional;

public interface CacheRepository<K, T> {

    void add (Optional<List<T>> list);
    void add(K key, Optional<T> element);
    Optional<T> get(K key);

}
