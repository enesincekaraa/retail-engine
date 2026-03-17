package com.enesincekara.retail.application.product;

import com.enesincekara.retail.domain.product.Product;
import com.enesincekara.retail.domain.product.ProductId;
import com.enesincekara.retail.domain.product.ProductRepository;
import com.enesincekara.retail.domain.shared.Money;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UpdateProductUseCase {

    private final ProductRepository productRepository;

    public UpdateProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @CacheEvict(value = "products", key = "#id")
    public Product execute(String id, String name, BigDecimal price) {
        Product product = productRepository.findById(ProductId.of(id))
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        product.update(name,new Money(price,"TRY"));
        return productRepository.save(product);
    }

}
