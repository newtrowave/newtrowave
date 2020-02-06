package com.kostars.newtroshop.web;

import com.kostars.newtroshop.domain.product.Product;
import com.kostars.newtroshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "")
    public int create(Product product) {

        product.setCreatedAt(product.getCreatedAt() == null ? LocalDateTime.now() : product.getCreatedAt());

        productService.create(product);

        return 1;
    }


}
