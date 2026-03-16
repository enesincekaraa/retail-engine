package com.enesincekara.retail.interfaces.rest;

import com.enesincekara.retail.application.product.CreateProductUseCase;
import com.enesincekara.retail.domain.product.Product;
import com.enesincekara.retail.interfaces.dto.CreateProductRequest;
import com.enesincekara.retail.interfaces.dto.ProductResponse;
import com.enesincekara.retail.interfaces.mapper.ProductMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;

    public ProductController(CreateProductUseCase createProductUseCase) {
        this.createProductUseCase = createProductUseCase;
    }

    @PostMapping
    public ProductResponse createProduct(@Valid @RequestBody CreateProductRequest req){
        Product product = ProductMapper.toDomain(req);
        Product savedProduct=createProductUseCase.execute(
                product.getName(),
                product.getPrice()
        );
        return ProductMapper.toResponse(savedProduct);
    }
}
