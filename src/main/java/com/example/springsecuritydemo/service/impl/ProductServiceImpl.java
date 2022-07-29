package com.example.springsecuritydemo.service.impl;

import com.example.springsecuritydemo.entity.Product;
import com.example.springsecuritydemo.models.request.ProductRequestPayload;
import com.example.springsecuritydemo.repository.ProductRepository;
import com.example.springsecuritydemo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product create(ProductRequestPayload productRequestPayload) {
        Product product = new Product();
        product.setName(productRequestPayload.getName());
        product.setPrice(productRequestPayload.getPrice());
        return productRepository.save(product);
    }
}
