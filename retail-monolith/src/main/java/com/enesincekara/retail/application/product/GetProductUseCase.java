package com.enesincekara.retail.application.product;

import com.enesincekara.retail.domain.product.Product;
import com.enesincekara.retail.domain.product.ProductId;
import com.enesincekara.retail.domain.product.ProductRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class GetProductUseCase {
    private final ProductRepository productRepository;
    public GetProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Cacheable(value = "products", key = "#id",unless = "#result == null")
    public Product execute(String id) {
        return productRepository.findById(ProductId.of(id))
                .orElseThrow(
                        ()->new RuntimeException("Product not found with id: " + id)
                );
    }
}
