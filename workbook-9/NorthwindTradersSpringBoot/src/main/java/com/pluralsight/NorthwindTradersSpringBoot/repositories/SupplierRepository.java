package com.pluralsight.NorthwindTradersSpringBoot.repositories;

import com.pluralsight.NorthwindTradersSpringBoot.models.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SupplierRepository extends JpaRepository<Suppliers, Integer>, JpaSpecificationExecutor<Suppliers> {
}
