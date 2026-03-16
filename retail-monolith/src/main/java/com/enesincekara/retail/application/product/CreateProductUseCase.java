package com.enesincekara.retail.application.product;

import com.enesincekara.retail.domain.product.Product;
import com.enesincekara.retail.domain.product.ProductRepository;
import com.enesincekara.retail.domain.shared.Money;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCase {
    private final ProductRepository productRepository;

    public CreateProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product execute(String name, Money price) {
        Product product = Product.create(name, price);
        return productRepository.save(product);
    }
}
