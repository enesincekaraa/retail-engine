package com.enesincekara.retail.interfaces.rest;

import com.enesincekara.retail.application.product.CreateProductUseCase;
import com.enesincekara.retail.application.product.GetProductUseCase;
import com.enesincekara.retail.application.product.UpdateProductUseCase;
import com.enesincekara.retail.domain.product.Product;
import com.enesincekara.retail.interfaces.dto.CreateProductRequest;
import com.enesincekara.retail.interfaces.dto.ProductResponse;
import com.enesincekara.retail.interfaces.dto.UpdateProductRequest;
import com.enesincekara.retail.interfaces.mapper.ProductMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final GetProductUseCase getProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;

    public ProductController(CreateProductUseCase createProductUseCase, GetProductUseCase getProductUseCase, UpdateProductUseCase updateProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.getProductUseCase = getProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
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

    @PutMapping("/{id}")
    public ProductResponse updateProduct(
            @PathVariable String id,
            @RequestBody UpdateProductRequest request) {

        Product updated = updateProductUseCase.execute(
                id,
                request.getName(),
                request.getPrice()
        );

        return ProductMapper.toResponse(updated);
    }
}
