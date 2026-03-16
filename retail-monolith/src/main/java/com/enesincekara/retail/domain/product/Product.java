package com.enesincekara.retail.domain.product;

import com.enesincekara.retail.domain.shared.DomainException;
import com.enesincekara.retail.domain.shared.Money;

public class Product {
    private ProductId id;
    private String name;
    private Money price;

    public Product(ProductId id, String name, Money price) {
        if (name == null||name.isBlank()) {
            throw new DomainException("Product name cannot be null or empty");
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static Product create(String name, Money price) {
        if (name == null||name.isBlank()) {
            throw new DomainException("Product name cannot be null or empty");
        }
        ProductId id = ProductId.newId();
        return new Product(id, name, price);
    }

    public void changedPrice(Money newPrice) {
        if (newPrice == null) {
            throw new DomainException("Price cannot be null");
        }
        this.price = newPrice;
    }
    public ProductId getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Money getPrice() {
        return price;
    }
}
