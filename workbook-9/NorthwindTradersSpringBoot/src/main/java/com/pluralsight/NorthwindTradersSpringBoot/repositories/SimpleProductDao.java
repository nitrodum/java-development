package com.pluralsight.NorthwindTradersSpringBoot.repositories;

import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class SimpleProductDao implements ProductDao{

    private HashMap<Integer, Product> hashMap;
    private int counter = 5;

    public SimpleProductDao() {
        this.hashMap = new HashMap<>();

        this.hashMap.put(1, new Product(1, "Chai", "1", 18));
        this.hashMap.put(2, new Product(2, "Chang", "1", 19));
        this.hashMap.put(3, new Product(3, "Aniseed Syrup", "2", 10));
        this.hashMap.put(4, new Product(3, "Chef Anton's Cajun Seasoning", "2", 22));
    }


    @Override
    public int add(Product product) {
        int freshId = counter++;
        this.hashMap.put(freshId, new Product(freshId, product.getName(), product.getCategory(), product.getPrice()));
        return freshId;
    }

    @Override
    public List<Product> getAll() {
        return this.hashMap.values().stream().toList();
    }

    @Override
    public Product getById(int id) {
        return this.hashMap.get(id);
    }

    @Override
    public Product update(int id, Product product) {
        Product toChange = this.hashMap.get(id);
        toChange.setName(product.getName());
        toChange.setCategory(product.getCategory());
        toChange.setPrice(product.getPrice());
        return toChange;
    }

    @Override
    public void delete(int id) {
        this.hashMap.remove(id);
    }
}
