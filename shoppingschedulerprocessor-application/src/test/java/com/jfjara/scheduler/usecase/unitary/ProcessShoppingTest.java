package com.jfjara.scheduler.usecase.unitary;

import com.jfjara.scheduler.model.ShoppingDTO;
import com.jfjara.scheduler.usecase.ProcessShopping;
import com.jfjara.scheduler.utils.DTOGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class ProcessShoppingTest {

    ProcessShopping processShopping;

    @Before
    public void init() {
        processShopping = new ProcessShopping();
    }

    @Test
    public void test_shoppings_with_results() {
        Optional<List<ShoppingDTO>> filtered = processShopping.execute(DTOGenerator.createShoppings().get());
        Assert.assertNotNull(filtered);
        Assert.assertFalse(filtered.isEmpty());
        Assert.assertTrue(filtered.get().size() == 1);
    }

    @Test
    public void test_shoppings_without_results() {
        Optional<List<ShoppingDTO>> filtered = processShopping.execute(DTOGenerator.createCheapShoppings().get());
        Assert.assertNotNull(filtered);
        Assert.assertTrue(filtered.get().isEmpty());
    }

    @Test
    public void test_empty_shoppings() {
        Optional<List<ShoppingDTO>> filtered = processShopping.execute(new ArrayList<>());
        Assert.assertNotNull(filtered);
        Assert.assertTrue(filtered.get().isEmpty());
    }

}
