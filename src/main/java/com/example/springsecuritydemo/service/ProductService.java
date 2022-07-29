package com.example.springsecuritydemo.service;

import com.example.springsecuritydemo.entity.Product;
import com.example.springsecuritydemo.models.request.ProductRequestPayload;

import java.util.List;

public interface  ProductService {
    List<Product> getAllProducts();

    Product create(ProductRequestPayload productRequestPayload);
}
