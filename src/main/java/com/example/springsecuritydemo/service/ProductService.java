package com.example.springsecuritydemo.service;

import com.example.springsecuritydemo.entity.Product;
import com.example.springsecuritydemo.models.request.ProductRequestPayload;

import java.util.List;

public abstract class ProductService {
    public abstract List<Product> getAllProducts();

    public abstract Product create(ProductRequestPayload productRequestPayload);
}
