package com.pluralsight.NorthwindTradersSpringBoot.repositories;

import com.pluralsight.NorthwindTradersSpringBoot.models.Product;

import java.util.List;

public interface ProductDao {
    int add(Product product);
    List<Product> getAll();
    Product getById(int id);
    Product update(int id, Product product);
    void delete(int id);
}
