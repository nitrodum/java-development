package com.pluralsight.NorthwindTradersSpringBoot.search;

import com.pluralsight.NorthwindTradersSpringBoot.models.Suppliers;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class SupplierSpecificationsBuilder {

    private final List<SearchCriteria> params = new ArrayList<>();

    public SupplierSpecificationsBuilder with(String key, String operation, Object value, boolean orPredicate) {
        params.add(new SearchCriteria(orPredicate, key, operation, value));
        return this;
    }

    public Specification<Suppliers> build() {
        if (params.isEmpty()) {
            return null;
        }

        Specification<Suppliers> result = new SupplierSpecification(params.get(0));
        for (int i = 1; i < params.size(); i++) {
            SearchCriteria criteria = params.get(i);
            result = criteria.isOrPredicate() ?
                    Specification.where(result).or(new SupplierSpecification(criteria)) :
                    Specification.where(result).and(new SupplierSpecification(criteria));
        }
        return result;
    }
}