package com.pluralsight.NorthwindTradersSpringBoot.controllers;

import com.pluralsight.NorthwindTradersSpringBoot.models.Category;
import com.pluralsight.NorthwindTradersSpringBoot.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    private CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(@RequestParam(required = false) String categoryName) {

        List<Category> filter = service.getAll();
        if (categoryName != null) {
            filter = filter.stream().filter(category -> category.getCategoryName().equalsIgnoreCase(categoryName)).toList();
        }

        return ResponseEntity.ok(filter);
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        Category c = service.getById(id);
        if (c != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(c);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
