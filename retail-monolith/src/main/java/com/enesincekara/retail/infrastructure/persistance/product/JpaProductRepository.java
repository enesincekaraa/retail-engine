package com.enesincekara.retail.infrastructure.persistance.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<ProductEntity, String> {

}
