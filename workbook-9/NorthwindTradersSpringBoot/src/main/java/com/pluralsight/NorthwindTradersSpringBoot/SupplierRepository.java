package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SupplierRepository extends JpaRepository<Suppliers, Integer>, JpaSpecificationExecutor<Suppliers> {
}
