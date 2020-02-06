package com.kostars.newtroshop.service;

import com.kostars.newtroshop.domain.product.Product;
import com.kostars.newtroshop.domain.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public int create(Product product) {

        Product p = productRepository.save(product);

        return product != null ? 1 : 0;
    }
}
