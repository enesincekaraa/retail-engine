package com.enesincekara.retail.interfaces.dto;


import java.math.BigDecimal;

public class CreateProductRequest {
    private String  name;
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
