package com.kostars.newtroshop.web;

import com.kostars.newtroshop.domain.CrudInterface;
import com.kostars.newtroshop.domain.Header;
import com.kostars.newtroshop.service.ProductService;
import com.kostars.newtroshop.web.dto.request.ProductRequestDto;
import com.kostars.newtroshop.web.dto.response.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController implements CrudInterface<ProductRequestDto, ProductResponseDto> {

    @Autowired
    private ProductService productService;

    @Override
    @PostMapping(value = "", consumes = "application/json;charset=UTF-8")
    public Header<ProductResponseDto> create(@RequestBody Header<ProductRequestDto> request) {

        System.out.println("request : " + request);
        System.out.println("data : " + request.getData());

        return new Header<ProductResponseDto>();
    }

    @Override
    @GetMapping(value = "{id}")
    public Header<ProductResponseDto> read(@PathVariable Long id) {
        return productService.read(id);
    }

    @GetMapping(value = "")
    public Header<ProductResponseDto> readAll() {
        Header<ProductResponseDto> a = productService.readAll();
        System.out.println(a);
        return a;
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
