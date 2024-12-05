package com.pluralsights.demo;

import com.pluralsights.demo.models.Course;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class CourseSpecification implements Specification<Course> {

    @Override
    public Predicate toPredicate
            (Root<Course> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return null;
    }
}
