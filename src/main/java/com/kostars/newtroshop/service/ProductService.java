package com.kostars.newtroshop.service;

import com.kostars.newtroshop.domain.CrudInterface;
import com.kostars.newtroshop.domain.Header;
import com.kostars.newtroshop.domain.product.Product;
import com.kostars.newtroshop.domain.product.ProductRepository;
import com.kostars.newtroshop.web.dto.request.ProductRequestDto;
import com.kostars.newtroshop.web.dto.response.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class ProductService implements CrudInterface<ProductRequestDto, ProductResponseDto> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Header<ProductResponseDto> create(Header<ProductRequestDto> request) {

        ProductRequestDto body = request.getData();

        Product product = Product.builder()
                .productName(body.getProductName())
                .productPrice(body.getProductPrice())
                .productContent(body.getProductContent())
                .productColor(body.getProductColor())
                .createdAt(LocalDateTime.now())
                .productStock(body.getProductStock())
                .build();

        Product p = productRepository.save(product);

        return response(p);
    }

    @Override
    public Header<ProductResponseDto> read(Long id) {
        return null;
    }

    @Override
    public Header<ProductResponseDto> update(Header<ProductRequestDto> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }

    private Header<ProductResponseDto> response(Product product) {

        ProductResponseDto body = ProductResponseDto.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .productColor(product.getProductColor())
                .productContent(product.getProductContent())
                .createdAt(product.getCreatedAt())
                .productStock(product.getProductStock())
                .build();

        return Header.OK(body);
    }
}
