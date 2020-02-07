package com.kostars.newtroshop.web;

import com.kostars.newtroshop.domain.CrudInterface;
import com.kostars.newtroshop.domain.Header;
import com.kostars.newtroshop.service.ProductService;
import com.kostars.newtroshop.web.dto.request.ProductRequestDto;
import com.kostars.newtroshop.web.dto.response.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController implements CrudInterface<ProductRequestDto, ProductResponseDto> {

    @Autowired
    private ProductService productService;

    @Override
    @PostMapping("")
    public Header<ProductResponseDto> create(Header<ProductRequestDto> request) {

        return productService.create(request);
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
}
