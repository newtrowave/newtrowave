package com.kostars.newtroshop.service;

import com.kostars.newtroshop.domain.product.category.Category;
import com.kostars.newtroshop.domain.product.category.CategoryRepository;
import com.kostars.newtroshop.domain.product.category.keyword.Keyword;
import com.kostars.newtroshop.domain.product.category.keyword.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private KeywordRepository keywordRepository;

    public Category createCategory(Category category) {

        return categoryRepository.save(category);
    }

    public List<Category> categoryList(String categoryName) {

        return categoryRepository.findAllByCategoryNameContaining(categoryName);
    }

    public Keyword createKeyword(Keyword keyword) {

        return keywordRepository.save(keyword);
    }

    public List<Keyword> keywordList(String keywordName) {

        return keywordRepository.findAllByKeywordNameContaining(keywordName);
    }

    public Category categorySelect(Long categoryId) {

        Optional<Category> category = categoryRepository.findById(categoryId);

        return category.isPresent() ? category.get() : null;
    }

    public Keyword keywordSelect(Long keywordId) {

        Optional<Keyword> keyword = keywordRepository.findById(keywordId);

        return keyword.isPresent() ? keyword.get() : null;
    }
}
