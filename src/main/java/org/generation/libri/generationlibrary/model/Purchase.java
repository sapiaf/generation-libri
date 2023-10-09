package org.generation.libri.generationlibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime dateOfPurchase;
    @NotNull
    @Min(1)
    private int purchaseQuantity;
    private BigDecimal totalPrice;

    @ManyToOne
    private Book book;

    //constructor
    public Purchase(int id, LocalDateTime dateOfPurchase, int purchaseQuantity, BigDecimal totalPrice, Book book) {
        this.id = id;
        this.dateOfPurchase = dateOfPurchase;
        this.purchaseQuantity = purchaseQuantity;
        this.totalPrice = calculateCost();
        this.book = book;
    }

    //constructor default
    public Purchase() {
    }

    //getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDateTime dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice = calculateCost();
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal calculateCost() {
        return this.totalPrice = book.getPrice().multiply(BigDecimal.valueOf(purchaseQuantity));
    }
}
