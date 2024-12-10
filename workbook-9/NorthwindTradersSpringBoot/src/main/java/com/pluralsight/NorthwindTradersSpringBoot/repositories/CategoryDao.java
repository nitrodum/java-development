package com.pluralsight.NorthwindTradersSpringBoot.repositories;


import com.pluralsight.NorthwindTradersSpringBoot.models.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> getAll();
    Category getById(int id);
}
