package com.pluralsight.NorthwindTradersSpringBoot.search;

public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
    private boolean orPredicate;

    public SearchCriteria() {

    }

    public SearchCriteria(boolean orPredicate, String key, String operation, Object value) {
        this.orPredicate = orPredicate;
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    public boolean isOrPredicate() {
        return orPredicate;
    }

    public void setOrPredicate(boolean orPredicate) {
        this.orPredicate = orPredicate;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
