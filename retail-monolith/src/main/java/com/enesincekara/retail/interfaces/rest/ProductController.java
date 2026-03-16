package com.enesincekara.retail.interfaces.rest;

import com.enesincekara.retail.application.product.CreateProductUseCase;
import com.enesincekara.retail.application.product.GetProductUseCase;
import com.enesincekara.retail.domain.product.Product;
import com.enesincekara.retail.interfaces.dto.CreateProductRequest;
import com.enesincekara.retail.interfaces.dto.ProductResponse;
import com.enesincekara.retail.interfaces.mapper.ProductMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final GetProductUseCase getProductUseCase;

    public ProductController(CreateProductUseCase createProductUseCase, GetProductUseCase getProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.getProductUseCase = getProductUseCase;
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
    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable("id") String id){
        Product product = getProductUseCase.execute(id);
        return ProductMapper.toResponse(product);
    }
}
