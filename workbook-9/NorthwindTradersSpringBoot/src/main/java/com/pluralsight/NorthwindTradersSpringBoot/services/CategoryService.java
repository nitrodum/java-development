package com.pluralsight.NorthwindTradersSpringBoot.services;

import com.pluralsight.NorthwindTradersSpringBoot.models.Category;
import com.pluralsight.NorthwindTradersSpringBoot.repositories.CategoryDao;
import com.pluralsight.NorthwindTradersSpringBoot.repositories.JdbcCategoryDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private JdbcCategoryDao categoryDao;

    public CategoryService(JdbcCategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    public Category getById(int id) {
        return categoryDao.getById(id);
    }
}
