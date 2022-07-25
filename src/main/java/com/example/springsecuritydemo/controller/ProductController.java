package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.entity.Product;
import com.example.springsecuritydemo.models.request.ProductRequestPayload;
import com.example.springsecuritydemo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> list() {
        return productService.getAllProducts();
    }

    @PostMapping("/product")
    public Product create(@RequestBody @Valid ProductRequestPayload productRequestPayload) {
        return productService.create(productRequestPayload);
    }
}
