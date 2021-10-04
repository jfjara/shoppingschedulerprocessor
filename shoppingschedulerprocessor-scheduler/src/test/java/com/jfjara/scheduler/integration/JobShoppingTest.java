package com.jfjara.scheduler.integration;

import com.jfjara.scheduler.config.JobShopping;
import com.jfjara.scheduler.model.ShoppingDTO;
import com.jfjara.scheduler.usecase.GetShoppings;
import com.jfjara.scheduler.usecase.ProcessShopping;
import com.jfjara.scheduler.usecase.SaveShopping;
import com.jfjara.scheduler.utils.DTOGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

@RunWith(MockitoJUnitRunner.class)
public class JobShoppingTest {

    @Mock
    GetShoppings getShoppings;

    @Mock
    ProcessShopping processShopping;

    @Mock
    SaveShopping saveShopping;

    @InjectMocks
    JobShopping jobShopping;

    @Test
    public void when_job_start_get_process_and_save_shoppings() {

        given(getShoppings.execute()).willReturn(DTOGenerator.createShoppings());
        given(processShopping.execute(anyList())).willReturn(DTOGenerator.createFilteredShoppings());
        doNothing().when(saveShopping).execute(any());

        Optional<List<ShoppingDTO>> shoppingsSaved = jobShopping.job();
        Assert.assertNotNull(shoppingsSaved);
        Assert.assertFalse(shoppingsSaved.isEmpty());
        Assert.assertNotNull(shoppingsSaved.get().get(0).getId());
        Assert.assertEquals("2", shoppingsSaved.get().get(0).getId());
    }

}
