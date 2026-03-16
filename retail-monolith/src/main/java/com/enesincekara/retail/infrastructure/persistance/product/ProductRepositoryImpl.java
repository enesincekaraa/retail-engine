package com.enesincekara.retail.infrastructure.persistance.product;

import com.enesincekara.retail.domain.product.Product;
import com.enesincekara.retail.domain.product.ProductId;
import com.enesincekara.retail.domain.product.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final JpaProductRepository jpaProductRepository;

    public ProductRepositoryImpl(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity =ProductEntityMapper.toEntity(product);
        ProductEntity savedEntity = jpaProductRepository.save(entity);
        return ProductEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Product> findById(ProductId id) {
        return jpaProductRepository.findById(id.getValue())
                .map(ProductEntityMapper::toDomain);
    }
}
