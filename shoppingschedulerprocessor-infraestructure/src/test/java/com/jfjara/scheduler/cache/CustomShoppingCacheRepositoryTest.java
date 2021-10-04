package com.jfjara.scheduler.cache;

import com.jfjara.scheduler.model.ShoppingDTO;
import com.jfjara.scheduler.utils.DTOGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class CustomShoppingCacheRepositoryTest {

    CacheRepository<String, ShoppingDTO> cacheRepository;

    @Before
    public void init() {
        cacheRepository = new CustomShoppingCacheRepository(new HashMap<>());
    }

    @Test
    public void test_add_elements_and_recovery() {
        ShoppingDTO shoppingLuisGarcia = DTOGenerator.createShoppingLuisGarcia();
        cacheRepository.add(shoppingLuisGarcia.getId(), Optional.of(shoppingLuisGarcia));
        Optional<ShoppingDTO> shoppingRecovered = cacheRepository.get(shoppingLuisGarcia.getId());
        Assert.assertNotNull(shoppingRecovered);
        Assert.assertTrue(shoppingRecovered.isPresent());
        Assert.assertEquals("1", shoppingRecovered.get().getId());
    }

    @Test
    public void test_add_empty_element() {
        cacheRepository.add("-1", Optional.empty());
        Optional<ShoppingDTO> shoppingRecovered = cacheRepository.get("-1");
        Assert.assertNotNull(shoppingRecovered);
        Assert.assertTrue(shoppingRecovered.isEmpty());
    }

    @Test
    public void test_recovery_no_exist() {
        Optional<ShoppingDTO> shoppingRecovered = cacheRepository.get("-1");
        Assert.assertNotNull(shoppingRecovered);
        Assert.assertTrue(shoppingRecovered.isEmpty());
    }

    @Test
    public void test_add_repeat_element() {
        ShoppingDTO shoppingLuisGarcia = DTOGenerator.createShoppingLuisGarcia();
        cacheRepository.add(shoppingLuisGarcia.getId(), Optional.of(shoppingLuisGarcia));
        Optional<ShoppingDTO> shoppingRecovered = cacheRepository.get(shoppingLuisGarcia.getId());
        Assert.assertNotNull(shoppingRecovered);
        Assert.assertTrue(shoppingRecovered.isPresent());
        Assert.assertEquals("1", shoppingRecovered.get().getId());
        Assert.assertEquals(80, shoppingRecovered.get().getTotalPrice().intValue());

        ShoppingDTO shoppingLuisGarcia2 = DTOGenerator.createShoppingLuisGarcia2();
        cacheRepository.add(shoppingLuisGarcia2.getId(), Optional.of(shoppingLuisGarcia2));
        Optional<ShoppingDTO> shoppingRecovered2 = cacheRepository.get(shoppingLuisGarcia2.getId());
        Assert.assertNotNull(shoppingRecovered2);
        Assert.assertTrue(shoppingRecovered2.isPresent());
        Assert.assertEquals("1", shoppingRecovered2.get().getId());
        Assert.assertEquals(900, shoppingRecovered2.get().getTotalPrice().intValue());
    }

}
