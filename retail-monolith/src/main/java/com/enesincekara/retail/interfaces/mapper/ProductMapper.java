package com.enesincekara.retail.interfaces.mapper;

import com.enesincekara.retail.domain.product.Product;
import com.enesincekara.retail.domain.shared.Money;
import com.enesincekara.retail.interfaces.dto.CreateProductRequest;
import com.enesincekara.retail.interfaces.dto.ProductResponse;

public class ProductMapper {
    public static Product toDomain(CreateProductRequest request) {
        return Product.create(
                request.getName(),
                new Money(request.getPrice(), "TRY"));
    }
    public static ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId().getValue(),
                product.getName(),
                product.getPrice().getAmount()
        );
    }
}
