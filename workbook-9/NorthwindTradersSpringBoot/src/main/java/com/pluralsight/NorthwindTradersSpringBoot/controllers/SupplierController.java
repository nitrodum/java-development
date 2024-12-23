package com.pluralsight.NorthwindTradersSpringBoot.controllers;

import com.pluralsight.NorthwindTradersSpringBoot.search.SupplierSpecificationsBuilder;
import com.pluralsight.NorthwindTradersSpringBoot.models.Suppliers;
import com.pluralsight.NorthwindTradersSpringBoot.services.SupplierService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("suppliers")
public class SupplierController {

    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public ResponseEntity<List<Suppliers>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    @GetMapping("{id}")
    public ResponseEntity<Suppliers> getSupplierById(@PathVariable int id) {
        Suppliers s = this.supplierService.getSupplierById(id);
        if (s != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(s);
        }
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public List<Suppliers> searchSuppliers(
            @RequestParam String key,
            @RequestParam String operation,
            @RequestParam String value,
            @RequestParam(defaultValue = "false") boolean orPredicate
    ) {
        SupplierSpecificationsBuilder builder = new SupplierSpecificationsBuilder();
        builder.with(key, operation, value, orPredicate);
        Specification<Suppliers> spec = builder.build();

        return this.supplierService.getSupplierRepository().findAll(spec);
    }

    @PostMapping
    public ResponseEntity<Suppliers> addSupplier(@RequestBody Suppliers suppliers) {
        Suppliers s = this.supplierService.addSupplier(suppliers);
        return ResponseEntity.status(HttpStatus.CREATED).body(s);
    }

    @PutMapping("{supplierID}")
    public ResponseEntity<Suppliers> updateSupplier(@PathVariable int supplierID, @RequestBody Suppliers suppliers) {
        Suppliers updated = this.supplierService.updateSupplier(supplierID, suppliers);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Suppliers> deleteSupplier(@PathVariable int id) {
        this.supplierService.delete(id);
        return ResponseEntity.ok().build();
    }
}
