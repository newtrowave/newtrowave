package com.kostars.newtroshop.web;

import com.kostars.newtroshop.domain.product.category.Category;
import com.kostars.newtroshop.domain.product.category.keyword.Keyword;
import com.kostars.newtroshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("")
    public int createCategory(@RequestBody Category category) {

        category = categoryService.createCategory(category);

        return category.getCategoryId() != null ? 1 : 0;
    }

    @PostMapping("/keyword")
    public int createKeyword(@RequestBody Keyword keyword) {

        keyword = categoryService.createKeyword(keyword);

        return keyword.getKeywordId() != null ? 1 : 0;
    }

    @GetMapping("{categoryName}")
    public List<Category> categoryList(@PathVariable String categoryName) {

        return categoryService.categoryList(categoryName);
    }

    @GetMapping("/keyword/{keywordName}")
    public List<Keyword> keywordList(@PathVariable String keywordName) {

        return categoryService.keywordList(keywordName);
    }

    @GetMapping("/id/{categoryId}")
    public Category categorySelect(@PathVariable Long categoryId) {

        return categoryService.categorySelect(categoryId);
    }

    @GetMapping("/keyword/id/{keywordId}")
    public Keyword keywordSelect(@PathVariable Long keywordId) {

        return categoryService.keywordSelect(keywordId);
    }
}
