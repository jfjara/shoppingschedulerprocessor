package com.jfjara.scheduler.config;

import com.jfjara.scheduler.cache.CacheRepository;
import com.jfjara.scheduler.client.ShoppingsClient;
import com.jfjara.scheduler.model.ShoppingDTO;
import com.jfjara.scheduler.usecase.GetShoppings;
import com.jfjara.scheduler.usecase.ProcessShopping;
import com.jfjara.scheduler.usecase.SaveShopping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public GetShoppings getShoppings(final ShoppingsClient shoppingsClient) {
        return new GetShoppings(shoppingsClient);
    }

    @Bean
    public ProcessShopping processShopping() {
        return new ProcessShopping();
    }

    @Bean
    public SaveShopping saveShopping(final CacheRepository<String, ShoppingDTO> cacheRepository) {
        return new SaveShopping(cacheRepository);
    }

}
