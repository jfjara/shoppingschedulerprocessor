package com.jfjara.scheduler.config;

import com.jfjara.scheduler.model.ShoppingDTO;
import com.jfjara.scheduler.usecase.GetShoppings;
import com.jfjara.scheduler.usecase.ProcessShopping;
import com.jfjara.scheduler.usecase.SaveShopping;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JobShopping {

    private final GetShoppings getShoppings;
    private final ProcessShopping processShopping;
    private final SaveShopping saveShopping;

    public JobShopping(GetShoppings getShoppings, ProcessShopping processShopping, SaveShopping saveShopping) {
        this.getShoppings = getShoppings;
        this.processShopping = processShopping;
        this.saveShopping = saveShopping;
    }

    @Scheduled(cron = "${cron}")
    public Optional<List<ShoppingDTO>> job() {
        Optional<List<ShoppingDTO>> shoppings = getShoppings.execute();
        Optional<List<ShoppingDTO>> shoppingsFiltered = shoppings
                .map(s -> processShopping.execute(s))
                .orElseGet(() -> Optional.empty());
        saveShopping.execute(shoppingsFiltered);
        return shoppingsFiltered;
    }

}
