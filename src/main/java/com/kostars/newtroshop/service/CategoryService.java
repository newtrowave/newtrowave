package com.kostars.newtroshop.service;

import com.kostars.newtroshop.domain.CrudInterface;
import com.kostars.newtroshop.domain.Header;
import com.kostars.newtroshop.domain.product.category.Category;
import com.kostars.newtroshop.domain.product.category.CategoryRepository;
import com.kostars.newtroshop.web.dto.request.CategoryRequestDto;
import com.kostars.newtroshop.web.dto.response.CategoryResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements CrudInterface<CategoryRequestDto, CategoryResponseDto> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Header<CategoryResponseDto> create(Header<CategoryRequestDto> request) {

        CategoryRequestDto body = request.getData();

        Category category = Category.builder()
                .categoryName(body.getCategoryName())
                .build();

        category = categoryRepository.save(category);

        return response(category);
    }

    @Override
    public Header<CategoryResponseDto> read(Long id) {

        return categoryRepository.findById(id)
                .map(this::response)
                .orElseGet(() -> Header.ERROR("No Data"));
    }

    public Header<CategoryResponseDto> readAll() {

        List<Category> categories = categoryRepository.findAll();

        return categories.isEmpty() ? Header.ERROR("No List Data") : responseAll(categories);
    }

    public Header<CategoryResponseDto> readAll(String categoryName) {

        List<Category> categories = categoryRepository.findAllByCategoryNameContaining(categoryName);

        return categories.isEmpty() ? Header.ERROR("No List Data") : responseAll(categories);
    }

    @Override
    public Header<CategoryResponseDto> update(Header<CategoryRequestDto> request) {      // todo Category delete 구현

        CategoryRequestDto body = request.getData();

        Category category = Category.builder()
                .categoryId(body.getCategoryId())
                .categoryName(body.getCategoryName())
                .build();

        Category newCategory = categoryRepository.save(category);

        return response(newCategory);
    }

    @Override
    public Header delete(Long id) {
        return null;
    }

    private Header<CategoryResponseDto> response(Category category) {

        CategoryResponseDto body = CategoryResponseDto.builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .build();

        return Header.OK(body);
    }

    private Header<CategoryResponseDto> responseAll(List<Category> categories) {

        CategoryResponseDto body = CategoryResponseDto.builder()
                .categories(categories)
                .build();

        return Header.OK(body);
    }

}
