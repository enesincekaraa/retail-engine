package com.enesincekara.retail.infrastructure.persistance.product;

import com.enesincekara.retail.domain.product.Product;
import com.enesincekara.retail.domain.product.ProductId;
import com.enesincekara.retail.domain.shared.Money;

public class ProductEntityMapper {
    public static ProductEntity toEntity(Product product) {
        return new ProductEntity(
                product.getId().getValue(),
                product.getName(),
                product.getPrice().getAmount()
        );
    }

    public static Product toDomain(ProductEntity entity) {

        return new Product(
                ProductId.of(entity.getId()),
                entity.getName(),
                new Money(entity.getPrice(), "TRY")
        );
    }
}
