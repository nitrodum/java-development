package com.pluralsight;

import java.time.LocalDate;

public class Book {
    String title;
    String author;
    float price;
    String isbn;

    public Book(String title, String author, float price, String isbn) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }

    public void display() {
        System.out.printf("Title: %s Author: %s Price: $%.2f + ISBN: %s", this.title, this.author, this.price, this.isbn);
    }

    public void discount(float discount) {
        this.price = this.price*discount;
    }

    public void discount(float discount, LocalDate startDate, LocalDate endDate) {
        if (LocalDate.now().isBefore(endDate) && LocalDate.now().isAfter(startDate)) {
            this.price = this.price*discount;
        } else if(startDate.isEqual(LocalDate.now()) || endDate.isEqual(LocalDate.now())) {
            this.price = this.price * discount;
        }
    }
}
