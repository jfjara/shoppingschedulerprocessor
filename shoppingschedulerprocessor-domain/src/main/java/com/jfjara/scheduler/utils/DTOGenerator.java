package com.jfjara.scheduler.utils;

import com.jfjara.scheduler.model.PersonDTO;
import com.jfjara.scheduler.model.ProductDTO;
import com.jfjara.scheduler.model.ShoppingDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DTOGenerator {

    public static ShoppingDTO createShoppingLuisGarcia() {
        return ShoppingDTO.builder()
                .id("1")
                .person(PersonDTO.builder().firstName("Luis").lastName("Garcia").id("1").build())
                .registerTimestamp(System.currentTimeMillis())
                .products(createProducts1())
                .build();
    }

    public static ShoppingDTO createShoppingLuisGarcia2() {
        return ShoppingDTO.builder()
                .id("1")
                .person(PersonDTO.builder().firstName("Luis").lastName("Garcia").id("1").build())
                .registerTimestamp(System.currentTimeMillis())
                .products(createProducts2())
                .build();
    }

    public static ShoppingDTO createShoppingMariaPerez() {
        return ShoppingDTO.builder()
                .id("2")
                .person(PersonDTO.builder().firstName("Maria").lastName("Perez").id("2").build())
                .registerTimestamp(System.currentTimeMillis())
                .products(createProducts2())
                .build();
    }

    public static Optional<List<ShoppingDTO>> createFilteredShoppings() {
        List<ShoppingDTO> result = new ArrayList<>();
        result.add(ShoppingDTO.builder()
                .id("2")
                .person(PersonDTO.builder().firstName("Maria").lastName("Perez").id("2").build())
                .registerTimestamp(System.currentTimeMillis())
                .products(createProducts2())
                .build());
        return Optional.of(result);
    }

    public static Optional<List<ShoppingDTO>> createShoppings() {
        List<ShoppingDTO> result = new ArrayList<>();
        result.add(ShoppingDTO.builder()
                .id("1")
                .person(PersonDTO.builder().firstName("Luis").lastName("Garcia").id("1").build())
                .registerTimestamp(System.currentTimeMillis())
                .products(createProducts1())
                .build());
        result.add(ShoppingDTO.builder()
                .id("2")
                .person(PersonDTO.builder().firstName("Maria").lastName("Perez").id("2").build())
                .registerTimestamp(System.currentTimeMillis())
                .products(createProducts2())
                .build());
        return Optional.of(result);
    }

    public static Optional<List<ShoppingDTO>> createCheapShoppings() {
        List<ShoppingDTO> result = new ArrayList<>();
        result.add(ShoppingDTO.builder()
                .id("1")
                .person(PersonDTO.builder().firstName("Luis").lastName("Garcia").id("1").build())
                .registerTimestamp(System.currentTimeMillis())
                .products(createProducts1())
                .build());
        result.add(ShoppingDTO.builder()
                .id("2")
                .person(PersonDTO.builder().firstName("Antonio").lastName("Martinez").id("3").build())
                .registerTimestamp(System.currentTimeMillis())
                .products(createProducts3())
                .build());
        return Optional.of(result);
    }

    public static List<ProductDTO> createProducts1() {
        List<ProductDTO> result = new ArrayList<>();
        result.add(ProductDTO.builder().id("1").title("P1").price(50L).build());
        result.add(ProductDTO.builder().id("2").title("P2").price(10L).build());
        result.add(ProductDTO.builder().id("3").title("P3").price(20L).build());
        return result;
    }

    public static List<ProductDTO> createProducts2() {
        List<ProductDTO> result = new ArrayList<>();
        result.add(ProductDTO.builder().id("1").title("P1").price(50L).build());
        result.add(ProductDTO.builder().id("4").title("P4").price(150L).build());
        result.add(ProductDTO.builder().id("5").title("P5").price(250L).build());
        result.add(ProductDTO.builder().id("6").title("P6").price(450L).build());
        return result;
    }

    public static List<ProductDTO> createProducts3() {
        List<ProductDTO> result = new ArrayList<>();
        result.add(ProductDTO.builder().id("1").title("P1").price(50L).build());
        return result;
    }


}
