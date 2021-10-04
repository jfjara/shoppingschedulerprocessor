package com.jfjara.scheduler.usecase.integration;

import com.jfjara.scheduler.client.ShoppingsClient;
import com.jfjara.scheduler.model.ShoppingDTO;
import com.jfjara.scheduler.usecase.GetShoppings;
import com.jfjara.scheduler.utils.DTOGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class GetShoppingsTest {

    @Mock
    ShoppingsClient shoppingsClient;

    @InjectMocks
    GetShoppings getShoppings;

    @Test
    public void when_request_shoppings_then_return_shopping_list() {
        BDDMockito.given(getShoppings.execute()).willReturn(DTOGenerator.createShoppings());
        Optional<List<ShoppingDTO>> result = getShoppings.execute();
        Assert.assertNotNull(result);
        Assert.assertTrue(result.isPresent());
        Assert.assertTrue(result.get().size() > 0);
    }

}
