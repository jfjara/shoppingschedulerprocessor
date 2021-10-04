package com.jfjara.scheduler.usecase.integration;

import com.jfjara.scheduler.cache.CacheRepository;
import com.jfjara.scheduler.model.ShoppingDTO;
import com.jfjara.scheduler.usecase.SaveShopping;
import com.jfjara.scheduler.utils.DTOGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class SaveShoppingTest {

    @Mock
    CacheRepository<String, ShoppingDTO> cacheRepository;

    @InjectMocks
    SaveShopping saveShopping;

    @Test
    public void give_shoppinglist_when_store_data_then_OK() {
        BDDMockito.doNothing().when(cacheRepository).add(ArgumentMatchers.isA(Optional.class));
        saveShopping.execute(DTOGenerator.createCheapShoppings());

    }

}
