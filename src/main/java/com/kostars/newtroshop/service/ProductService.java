package com.kostars.newtroshop.service;

import com.kostars.newtroshop.domain.CrudInterface;
import com.kostars.newtroshop.domain.Header;
import com.kostars.newtroshop.domain.product.Product;
import com.kostars.newtroshop.domain.product.ProductRepository;
import com.kostars.newtroshop.service.exception.ProductNotFoundException;
import com.kostars.newtroshop.web.dto.request.ProductRequestDto;
import com.kostars.newtroshop.web.dto.response.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


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

        return productRepository.findById(id)
                .map(this::response)
                .orElseGet(() -> Header.ERROR("NO DATA"));

    }

    public Header<ProductResponseDto> readAll() {
        List<Product> products = productRepository.findAll();

        System.out.println("PRODUCT SERVICE #54 : " + products);

        return responseList(products);
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

    private Header<ProductResponseDto> responseList(List<Product> list) {
        ProductResponseDto body = ProductResponseDto.builder()
                .products(list)
                .build();

        return Header.OK(body);
    }

    public Product findById(Long id) {
        verifyIfNotExist(id);
        return productRepository.getOne(id);
    }

    private void verifyIfNotExist(Long id) {
        Optional<Product> foundProduct = productRepository.findById(id);
        if (!foundProduct.isPresent()) {
            throw new ProductNotFoundException();
        }
    }
}
