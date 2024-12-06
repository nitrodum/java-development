package com.pluralsight.NorthwindTradersSpringBoot.services;

import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import com.pluralsight.NorthwindTradersSpringBoot.repositories.ProductDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public int addProduct(Product product) {
        if (productDao.getAll().contains(product)) {
            System.out.println("Product already entered");
            return -1;
        } else {
            return productDao.add(product);
        }
    }

    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    public Product getProductById(int id) {
        return productDao.getById(id);
    }

    public Product updateProduct(int id, Product product) {
        return productDao.update(id, product);
    }

    public void delete(int id) {
        productDao.delete(id);
    }
}
