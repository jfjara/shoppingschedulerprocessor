package com.jfjara.scheduler.client.rest;

import com.jfjara.scheduler.client.ShoppingsClient;
import com.jfjara.scheduler.mapper.ShoppingMapper;
import com.jfjara.scheduler.model.ShoppingDTO;
import com.jfjara.shoppinggenerator.model.Shopping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShoppingsRestClient implements ShoppingsClient {

    private final RestTemplate restTemplate;
    private final ShoppingMapper shoppingMapper;
    private final String host;
    private final String path;

    public ShoppingsRestClient(final RestTemplate restTemplate,
                               final ShoppingMapper shoppingMapper,
                               final @Value("${api.host}") String host,
                               final @Value("${api.path.shoppings.get}") String path) {
        this.restTemplate = restTemplate;
        this.shoppingMapper = shoppingMapper;
        this.host = host;
        this.path = path;
    }

    @Override
    public Optional<List<ShoppingDTO>> get() {
        ResponseEntity<Shopping[]> response = restTemplate.getForEntity(host + path, Shopping[].class);
        List<Shopping> shoppings = Arrays.asList(response.getBody());
        List<ShoppingDTO> shoppingDTOS = shoppings.stream()
                .map(e -> shoppingMapper.asShoppingDTO(e))
                .collect(Collectors.toList());
        return Optional.of(shoppingDTOS);
    }
}
