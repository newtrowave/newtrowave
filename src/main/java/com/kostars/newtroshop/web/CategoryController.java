package com.kostars.newtroshop.web;

import com.kostars.newtroshop.domain.CrudInterface;
import com.kostars.newtroshop.domain.Header;
import com.kostars.newtroshop.service.CategoryService;
import com.kostars.newtroshop.web.dto.request.CategoryRequestDto;
import com.kostars.newtroshop.web.dto.response.CategoryResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController implements CrudInterface<CategoryRequestDto, CategoryResponseDto> {

    @Autowired
    private CategoryService categoryService;

    @Override
    @PostMapping("")
    public Header<CategoryResponseDto> create(Header<CategoryRequestDto> request) {

        return categoryService.create(request);
    }

    @Override
    @GetMapping("{categoryId}")
    public Header<CategoryResponseDto> read(@PathVariable Long categoryId) {

        return categoryService.read(categoryId);
    }

    @GetMapping("")
    public Header<CategoryResponseDto> readAll() {

        return categoryService.readAll();
    }

    @GetMapping("/list/{categoryName}")
    public Header<CategoryResponseDto> readAll(@PathVariable String categoryName) {

        return categoryService.readAll(categoryName);
    }

    @Override
    @PutMapping("")
    public Header<CategoryResponseDto> update(Header<CategoryRequestDto> request) {
        return categoryService.update(request);
    }

    @Override
    public Header delete(Long id) {
        return categoryService.delete(id);
    }

}
