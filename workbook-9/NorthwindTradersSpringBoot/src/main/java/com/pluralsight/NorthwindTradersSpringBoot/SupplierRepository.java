package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Suppliers, Integer> {
}
