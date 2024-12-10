package com.pluralsight.NorthwindTradersSpringBoot.controllers;

import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import com.pluralsight.NorthwindTradersSpringBoot.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String name,
                                                        @RequestParam(required = false) String categoryId,
                                                        @RequestParam(required = false) Double price,
                                                        @RequestParam(required = false) String operation) {
        List<Product> filter = productService.getAllProducts();
        if (name != null) {
            filter = filter.stream().filter(product -> product.getName().equalsIgnoreCase(name)).toList();
        }
        if (categoryId != null) {
            filter = filter.stream().filter(product -> product.getCategory().equalsIgnoreCase(categoryId)).toList();
        }
        if (price != null) {
            if (operation.equalsIgnoreCase(">")) {
                filter = filter.stream().filter(product -> product.getPrice() > price).toList();
            } else if(operation.equalsIgnoreCase("<")) {
                filter = filter.stream().filter(product -> product.getPrice() < price).toList();
            } else {
                filter = filter.stream().filter(product -> product.getPrice() == price).toList();
            }
        }
        return ResponseEntity.ok(filter);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product p = productService.getProductById(id);
        if (p != null) {
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        if (productService.addProduct(product) != -1) {
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product p = productService.updateProduct(id, product);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable int id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }

}
